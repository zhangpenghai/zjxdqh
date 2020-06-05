package com.zjxdqh.happchargeserver.controller;

import com.zjxdqh.face.enums.OrderEnum;
import com.zjxdqh.face.exception.BuzzException;
import com.zjxdqh.face.exception.ExceptionEnum;
import com.zjxdqh.face.param.PayOrderParam;
import com.zjxdqh.face.service.HappyCouponService;
import com.zjxdqh.face.service.HappyOrderService;
import com.zjxdqh.face.service.HappyService;
import com.zjxdqh.face.service.HappyWalletService;
import com.zjxdqh.face.vo.*;
import com.zjxdqh.happchargeserver.mapper.*;
import com.zjxdqh.face.vo.*;
import com.zjxdqh.happchargeserver.mapper.FPileMapper;
import com.zjxdqh.happchargeserver.mapper.FPileSiteMapper;
import com.zjxdqh.happchargeserver.mapper.ForderMapper;
import com.zjxdqh.happchargeserver.mapper.ForderSettlementMapper;
import com.zjxdqh.happchargeserver.service.CommonService;
import com.zjxdqh.tools.MathUtils;
import com.zjxdqh.tools.lock.DistributeLock;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yorking
 * @date 2019/05/09
 */
@RestController
@Log4j2
public class HappyOrderServiceImpl implements HappyOrderService {


    @Autowired
    ForderMapper forderMapper;

    @Autowired
    FPileSiteMapper fPileSiteMapper;

    @Autowired
    FAccountInfoMapper fAccountInfoMapper;

    @Autowired
    ForderSettlementMapper forderSettlementMapper;

    @Autowired
    FPileMapper fPileMapper;

    @Autowired
    FPileGunMapper fPileGunMapper;

    @Autowired
    FPileTimePriceMapper fPileTimePriceMapper;

    @Resource
    private CommonService commonService;

    @Autowired
    private DistributeLock distributeLock;

    /**
     * 查询个人和企业的冻结金额
     *
     * @param uid
     * @return
     */
    @Override
    public FrozenAccountVo getFrozenAccount(Integer uid) {
        FrozenAccountVo frozenAccountVo = new FrozenAccountVo();
        // 获取个人用户冻结金额
        BigDecimal aloneFrozenBalance = forderMapper.getAloneFrozenBalance(uid);
        // 获取该企业子账户冻结金额
        BigDecimal enterpriseFrozenBalance = forderMapper.getEnterpriseFrozenBalance(uid);

        if (aloneFrozenBalance == null) {
            frozenAccountVo.setAloneFrozenBalance(new BigDecimal(0));
        } else {
            frozenAccountVo.setAloneFrozenBalance(aloneFrozenBalance);
        }

        if (enterpriseFrozenBalance == null) {
            frozenAccountVo.setEnterpriseFrozenBalance(new BigDecimal(0));
        } else {
            frozenAccountVo.setEnterpriseFrozenBalance(enterpriseFrozenBalance);
        }
        return frozenAccountVo;
    }

    /**
     * 查询该用户“不包含”多个状态的订单详情
     *
     * @param uid
     * @param ostate
     * @return
     */
    @Override
    public List<FOrder> queryAllComingOrders(Integer uid, List<Integer> ostate) {
        return forderMapper.queryAllComingOrders(uid, ostate);
    }

    /**
     * 根据sn查询当前订单信息
     *
     * @param pileNum
     * @param gunNum
     * @return
     */
    @Override
    public FOrder queryLastOrder(String pileNum, String gunNum) {
        if (StringUtils.isEmpty(pileNum) || StringUtils.isEmpty(gunNum)) {
            throw new BuzzException(ExceptionEnum.ERROR_PARAM);
        }
        return forderMapper.queryLastOrder(pileNum, gunNum);
    }


    /**
     * 根据sn查询当前订单信息
     *
     * @param sn
     * @return
     */
    @Override
    public FOrder queryChargingDetails(String sn) {
        Map<String, Object> param = new HashMap<>();
        param.put("sn", sn);
        return forderMapper.getOne(param);
    }


    /**
     * 根据桩号查询充电桩基本信息
     *
     * @param pilenum
     * @return
     */
    @Override
    public FPile queryFPile(String pilenum) {
        Map<String, Object> param = new HashMap<>();
        param.put("pilenum", pilenum);
        return fPileMapper.getOne(param);
    }

    /**
     * 根据充电站id查询充电站基本信息
     *
     * @param sid
     * @return
     */
    @Override
    public FPileSite queryFpileSite(String sid) {
        return fPileSiteMapper.selectByPrimaryKey(Integer.parseInt(sid));
    }

    @Override
    public List<PileStatusInfoVo> getListPileGun(String pilenum, String gnum) {
        return fPileGunMapper.getListPileGun(pilenum, gnum);
    }

    @Override
    public FPileTimePrice selectTime(String ptid) {

        //获取当前时间段电价
        Map map = new HashMap<>();
        map.put("id", ptid);
        Date date = new Date();
        String time = new SimpleDateFormat("HH:mm").format(date);
        map.put("time", "0000-00-00" + " " + time + ":00");
        FPileTimePrice fPileTimePrice = fPileTimePriceMapper.selectTime(map);
        return fPileTimePrice;
    }

    /**
     * 根据sn查询结算表数据
     *
     * @param sn
     * @return
     */
    @Override
    public com.zjxdqh.face.vo.FOrderSettlement getForderSettlement(String sn) {
        Map<String, Object> param = new HashMap<>();
        param.put("sn", sn);
        return forderSettlementMapper.getOne(param);
    }

    /**
     * 查询第一条流水创建时间  格式: "2019-08"
     *
     * @param uid
     * @return
     */
    @Override
    public String getOrderStarttime(Integer uid) {
        return fAccountInfoMapper.getOrderStarttime(uid);
    }


    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean payOrder(PayOrderParam param) {
        FOrder order = param.getOrder();
        FOrderSettlement settlement = param.getSettlement();
        FCouponsUser couponsUser = param.getCouponsUser();

        String lockKey = "LOCK:ACCOUNT:ORDER:" + order.getUid();


        try {
            if (distributeLock.tryLock(lockKey)) {

                FOrder paramOrder = queryChargingDetails(order.getSn());
                if (paramOrder.getOstate() == OrderEnum.Ostat.FINISH.key()) {
                    return true;
                }
                if (paramOrder.getOstate() != OrderEnum.Ostat.PAYING.key()) {
                    return false;
                }

                // 更新结算信息
                forderSettlementMapper.updateByPrimaryKeySelective(settlement);

                if (couponsUser != null) {
                    // 更新优惠券信息
                    commonService.updateOrderCoupons(couponsUser, settlement);
                }

                if (!commonService.updateAccount(order, null, settlement.getTotalAmount(),
                        "充电消费", CommonService.ACCOUNT_OPER_TYPE_CONSUME)) {
                    throw new BuzzException(ExceptionEnum.PAY_ERROR);
                }
                paramOrder = new FOrder();
                paramOrder.setOid(order.getOid());
                paramOrder.setOstate(OrderEnum.Ostat.FINISH.key());
                paramOrder.setBackMoney(MathUtils.subtract(order.getAmount(), settlement.getTotalAmount().doubleValue(), 2));
                // 更新订单状态
                forderMapper.updateByPrimaryKeySelective(paramOrder);
                return true;

            }
        } finally {
            distributeLock.releaseLock(lockKey);
        }
        return false;
    }


}
