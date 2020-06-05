package com.zjxdqh.happchargeserver.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjxdqh.face.enums.DataSource;
import com.zjxdqh.face.enums.DataSourceEnum;
import com.zjxdqh.face.enums.OrderEnum;
import com.zjxdqh.face.exception.BuzzException;
import com.zjxdqh.face.exception.ExceptionEnum;
import com.zjxdqh.face.param.*;
import com.zjxdqh.face.service.CollectService;
import com.zjxdqh.face.service.HappyService;
import com.zjxdqh.face.vo.*;
import com.zjxdqh.happchargeserver.mapper.*;
import com.zjxdqh.happchargeserver.model.FUser;
import com.zjxdqh.happchargeserver.model.ForderSettlement;
import com.zjxdqh.happchargeserver.service.CommonService;
import com.zjxdqh.tools.lock.DistributeLock;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Yorking
 * @date 2019/05/09
 */
@RestController
@Log4j2
public class HappyServiceImpl implements HappyService {

    @Resource
    @Lazy
    private CollectService collectService;

    @Resource
    FPileSiteMapper fpileSiteMapper;

    @Resource
    FPileMapper fPileMapper;

    @Resource
    private FPileGunMapper fPileGunMapper;

    @Resource
    private ChargeDataTempMapper chargeDataTempMapper;

    @Resource
    ForderMapper forderMapper;

    @Resource
    private FPileTimePriceMapper fPileTimePriceMapper;

    @Resource
    StationStatsInfoMapper stationStatsInfoMapper;

    @Resource
    BChargeEndInfoMapper bChargeEndInfoMapper;

    @Resource
    FOrderSettlementDetailMapper fOrderSettlementDetailMapper;

    @Resource
    ForderSettlementMapper forderSettlementMapper;
    @Resource
    private SupersiveInfoMapper supersiveInfoMapper;

    @Resource
    private FAccountMapper accountMapper;
    @Resource
    private FUserMapper userMapper;
    @Resource
    private FUserSettingMapper userSettingMapper;

    @Resource
    private EvcsPushPileMapper evcsPushPileMapper;

    @Resource
    private CommonService commonService;

    @Resource
    private DistributeLock distributeLock;

    public static final String Account_Lock_key = "LOCK:ACCOUNT:ORDER:";

    @Override
    public PileSite getPileSite(Integer sid) {
        FPileSite site = fpileSiteMapper.getOne(Collections.singletonMap("sid", sid));

        PileSite pileSite = new PileSite();
        BeanUtils.copyProperties(site, pileSite);

        return pileSite;
    }

    @Override
    public List<EvcsPushPile> getEvcsPushPile() {
        return evcsPushPileMapper.getEvcsPushPile();
    }

    /**
     * 根据桩编号查询桩信息
     * @param pilenum
     * @return
     */
    @Override
    public FPile getPileByNum(String pilenum) {
        Map<String,Object> param = new HashMap<>();
        param.put("pilenum",pilenum);
        return fPileMapper.getOne(param);
    }

    @Override
    @DataSource(DataSourceEnum.COLLECT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BChargeEndInfo getBChargeEndInfo(String orderNo) {
        BChargeEndInfo bChargeEndInfo = bChargeEndInfoMapper.findOne(orderNo);
        return bChargeEndInfo;
    }

    private PageInfo<FPileSite> getSuperviseSite(String operatorId, int pageNo, int pageSize) {
        return PageHelper.startPage(pageNo, pageSize, true, false)
                .doSelectPageInfo(() -> fpileSiteMapper.getSuperviseSite(operatorId));
    }

    @Override
    public PageInfo<FPileSite> getSuperviseSite(String operatorId, Date uptTime, int pageNo, int pageSize) {
        PageInfo<FPileSite> pageSites = getSuperviseSite(operatorId, pageNo, pageSize);
        List<FPileSite> sites = pageSites.getList();
        if (!CollectionUtils.isEmpty(sites)) {
            List<Integer> sids = new ArrayList<>();
            sites.forEach(m -> sids.add(m.getSid()));

            List<FPile> piles = fpileSiteMapper.getSupervisePile(sids, uptTime);

            sites.forEach(site -> {
                site.setPiles(new ArrayList<>());
                piles.forEach(p -> {
                    if (site.getSid().intValue() == p.getSid()) {
                        site.getPiles().add(p);

                    }
                });

            });
        }

        return pageSites;
    }

    /**
     * 查询充电状态
     * 若充电以结束，部分数据查询数据库
     * 若充电未结束，需要mq推送给我。
     * 充电状态接口：数据库一定能返回的数据
     *
     * @param chargeStateParam
     * @return
     */
    @Override
    public ChargeStateBaseVo queryChargeStateBaseVo(ChargeStateParam chargeStateParam) {
        String startChargeSeq = chargeStateParam.getStartChargeSeq();
        Map<String, Object> param = new HashMap<>();
        param.put("sn", startChargeSeq);
        param.put("superviseSn", chargeStateParam.getSn());
        param.put("superviseId", chargeStateParam.getSuperviseId());

        FOrder fOrder = forderMapper.getForderBaseData(param);
        if (fOrder != null) {
            // 根据充电订单查询：充电订单状态、开始充电时间、启动方式、本次采样时间
            ChargeStateBaseVo chargeStateBaseVo = new ChargeStateBaseVo();
            chargeStateBaseVo.setStartChargeSeq(fOrder.getSn());
            chargeStateBaseVo.setEndTime(new Date());
            chargeStateBaseVo.setStartChargeSeqStat(fOrder.getOstate());
            chargeStateBaseVo.setStartTime(fOrder.getCreatetime());
            chargeStateBaseVo.setChargeModel(fOrder.getPaytype());
            chargeStateBaseVo.setPid(fOrder.getPid());
            chargeStateBaseVo.setGunnumber(fOrder.getGunnumber());
            chargeStateBaseVo.setAmount(fOrder.getAmount().doubleValue());
            chargeStateBaseVo.setBackMoney(fOrder.getBackMoney().doubleValue());

            chargeStateBaseVo.setEndReason(fOrder.getEndReason());
            chargeStateBaseVo.setStartTime(fOrder.getStarttime());
            chargeStateBaseVo.setCreateTime(fOrder.getCreatetime());
            chargeStateBaseVo.setEndTime(fOrder.getEndtime());
            chargeStateBaseVo.setUseEle(fOrder.getUseele());
            chargeStateBaseVo.setVin(fOrder.getCarVin());
            chargeStateBaseVo.setSuperviseId(fOrder.getSuperviseId());
            chargeStateBaseVo.setSuperviseSn(fOrder.getSuperviseSn());
            chargeStateBaseVo.setUserId(fOrder.getUid());
            chargeStateBaseVo.setSn(fOrder.getSn());
            return chargeStateBaseVo;
        }
        log.error("查询订单[{}]返回结果为空", startChargeSeq);
        return null;
    }

    /**
     * 充电状态接口：充电成功后，返回部分数据
     *
     * @param chargeStateParam
     * @return
     */
    @Override
    public ChargeSuccessStateVo queryChargeSuccessStateVo(ChargeStateParam chargeStateParam) {
        ForderSettlement forderSettlement = forderSettlementMapper.getChargeSuccessState(chargeStateParam.getStartChargeSeq());
        if (forderSettlement != null) {
            ChargeSuccessStateVo chargeSuccessStateVo = new ChargeSuccessStateVo();
            chargeSuccessStateVo.setElecMoney(Double.parseDouble(forderSettlement.getEleAmount().toString()));
            chargeSuccessStateVo.setSeviceMoney(Double.parseDouble(forderSettlement.getServiceAmount().toString()));
            chargeSuccessStateVo.setSoc(Double.parseDouble(forderSettlement.getEsoc().toString()));
            chargeSuccessStateVo.setTotalMoney(Double.parseDouble(forderSettlement.getTotalAmount().toString()));
            chargeSuccessStateVo.setTotalPower(Double.parseDouble(forderSettlement.getUseele().toString()));
            return chargeSuccessStateVo;
        }
        log.error("查询订单[{}]结算信息返回结果为空", chargeStateParam.getStartChargeSeq());
        return null;
    }


    @Override
    public List<StationStatsInfo> queryStationStats(StationStatsInfoParam stationStatsInfoParam) {
        List<StationStatsInfo> stationStatsInfos = stationStatsInfoMapper.queryStationStats(stationStatsInfoParam);
        return stationStatsInfos;
    }


    @Override
    public List<PileStatusInfoVo> getPilesByStationId(String stationID) {
        return fPileGunMapper.getPilesByStationId(stationID);
    }

    @Override
    public PileStatusInfoVo getPilesByPilegnum(DeviceStatusParam statusParam) {
        return fPileGunMapper.getPilesByPilegnum(statusParam.getPilenum(), statusParam.getGnum());
    }

    @Override
    public StopChargeResultVo getStopChargeResult(String orderNo) {
        FOrder stopChargeResult = forderMapper.getStopChargeResult(orderNo);
        if (stopChargeResult != null) {
            StopChargeResultVo stopChargeResultVo = new StopChargeResultVo();
            stopChargeResultVo.setStartChargeSeqStat(stopChargeResult.getOstate());
            stopChargeResultVo.setPileNum(stopChargeResult.getPid());
            stopChargeResultVo.setGunNum(stopChargeResult.getGunnumber());
            stopChargeResultVo.setSuccStat(stopChargeResult.getOstate());
            stopChargeResultVo.setFailReason(stopChargeResult.getEndReason());
            return stopChargeResultVo;
        }
        return null;
    }

    @Override
    public SupersiveInfo getSupersiveInfo(String operatorId) {
        Map<String, Object> param = new HashMap<>();
        param.put("operatorId", operatorId);
        param.put("operatorStat", 1);
        return supersiveInfoMapper.getOne(param);
    }

    @Override
    public SupersiveInfo getSupersiveInfoById(String superviseId) {
        Map<String, Object> param = new HashMap<>();
        param.put("supersiveId", Integer.valueOf(superviseId));
        param.put("operator_stat", 1);
        return supersiveInfoMapper.getOne(param);
    }

    @Override
    public List<SupersiveInfo> getSupersiveInfoByPilenum(String pileNum) {
        return supersiveInfoMapper.getSupersiveInfoByPilenum(pileNum);
    }

    @Override
    public List<SupersiveInfo> getSupersiveInfoBySid(String sid) {
        return supersiveInfoMapper.getSupersiveInfoBySid(sid);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public StartChargeResult startCharge(StartChargeParam param) throws BuzzException {

        if (param == null || param.getUserId() == null || param.getAmount() == null
                || StringUtils.isEmpty(param.getPileNum()) || StringUtils.isEmpty(param.getGunNum())
                || param.getAmount().doubleValue() <= 0d) {
            throw new BuzzException(ExceptionEnum.ERROR_PARAM);
        }

        PileStatusInfoVo pileGun = fPileGunMapper.getPilesByPilegnum(param.getPileNum(), param.getGunNum());
        if (pileGun == null) {
            throw new BuzzException(ExceptionEnum.ERROR_GUN_STAT);
        }

        // 查询 桩状态
        QueryPileGunStateParam gunParam = new QueryPileGunStateParam();
        gunParam.setPilenum(param.getPileNum());
        gunParam.setGnum(param.getGunNum());
        List<PileGunStateVo> gunStat = collectService.queryPileGunState(gunParam);
        if (CollectionUtils.isEmpty(gunStat) || !"2".equalsIgnoreCase(gunStat.get(0).getGunChargingState())) {
            // 充电枪状态不是 已连接
            throw new BuzzException(ExceptionEnum.ERROR_GUN_STAT);
        }

        FOrder order = new FOrder();
        order.setAmount(param.getAmount());
        order.setSn(param.getOrderNo());
        order.setUid(param.getUserId());
        order.setPid(param.getPileNum());
        order.setGunnumber(param.getGunNum());
        order.setGid(pileGun.getGid());
        order.setSuperviseId(param.getSuperviseId());
        order.setSuperviseSn(param.getSuperviseSn());
        // 充电订单
        order.setOtype(1);
        // 状态 启动中
        order.setOstate(3);
        // 按金额充电
        order.setUseType(2);
        // 支付方式(2企业帐户)
        order.setPaytype(param.getPayType());
        if (param.getPayType() == 2) {
            FUser user = userMapper.getOne(Collections.singletonMap("uid", order.getUid()));
            if (user == null) {
                throw new BuzzException(ExceptionEnum.ERROR_PARAM);
            }
            order.setEcid(user.getCid());
        }

//        order.setCreatetime(new Date());
//        order.setBackMoney(BigDecimal.ZERO);
//        order.setUseele(0d);
//        order.setSetleStatus(0);
//        order.setBsoc(0);
//        order.setEsoc(0);

        String lockKey = Account_Lock_key + param.getUserId();

        try {

            if (distributeLock.tryLock(lockKey)) {
                // 设置 订单充值 默认金额
                FUserSetting userSetting = userSettingMapper.getFuserSettingByUid(order.getUid());
                if (userSetting != null && userSetting.getDefaultRechargeValue() != null
                        && userSetting.getDefaultRechargeValue().doubleValue() > 10) {
                    order.setAmount(userSetting.getDefaultRechargeValue());
                }

                //查询 帐户 状态
                com.zjxdqh.face.vo.user.FAccount account = accountMapper.getOne(Collections.singletonMap("uid", param.getUserId()));
                // 企业余额
                if (account == null) {
                    throw new BuzzException(ExceptionEnum.BALANCE_LACK);
                }
                if (order.getAmount() != null && order.getAmount().doubleValue() > 0) {
                    // 企业帐户余额不足
                    if (order.getPaytype() == OrderEnum.Paytype.Company.key()
                            && order.getAmount().doubleValue() > account.getAmount().doubleValue()) {
                        throw new BuzzException(ExceptionEnum.BALANCE_LACK);
                    }

                    if (order.getPaytype() == OrderEnum.Paytype.APP.key()
                            && order.getAmount().doubleValue() > account.getCash().doubleValue()) {
                        // 余额不足
                        throw new BuzzException(ExceptionEnum.BALANCE_LACK);
                    }
                }

                //查询 创建订单
                int oid = forderMapper.insertSelective(order);
                if (oid > 0) {
                    order = forderMapper.getOne(Collections.singletonMap("sn", param.getOrderNo()));
                    if (commonService.updateAccount(order, account, order.getAmount(), "预付费", CommonService.ACCOUNT_OPER_TYPE_FREEZONE)) {
                        StartChargeResult result = new StartChargeResult();
                        result.setSn(order.getSn());
                        result.setOid(order.getOid());
                        result.setOrderStat(order.getOstate());
                        result.setAmount(order.getAmount());
                        return result;
                    }
                    throw new BuzzException("订单创建异常.");
                }

            }
        } finally {
            distributeLock.releaseLock(lockKey);
        }
        return null;
    }

    /**
     * 查询业务策略信息结果
     *
     * @param pileNum
     * @return
     */
    @Override
    public List<PolicyInfo> getPolicyInfos(String pileNum) {

        log.info("getPolicyInfos 参数=[{}]", pileNum);

        List<PolicyInfo> policyInfos = new ArrayList<>();
        List<FPileTimePrice> fPileTimePrice = fPileTimePriceMapper.getPolicyInfos(pileNum);

        log.info("getPolicyInfos 查询结果=[{}]", fPileTimePrice);

        for (FPileTimePrice pileTimePrice : fPileTimePrice) {
            PolicyInfo policyInfo = new PolicyInfo();
            String stime = pileTimePrice.getStime();
            String replaceDate = stime.replace(":", "");
            policyInfo.setStartTime(replaceDate);
            policyInfo.setElecPrice(pileTimePrice.getPrice().doubleValue());
            policyInfo.setServicePrice(pileTimePrice.getServiceprice().doubleValue());
            policyInfos.add(policyInfo);
        }

        return policyInfos;
    }


    /**
     * 取消订单并退款
     *
     * @param orderNo
     */
    @Override
    public int backOrder(String orderNo) {
        if (StringUtils.isEmpty(orderNo)) {
            return 0;
        }

        FOrder order = forderMapper.getForderBaseData(Collections.singletonMap("sn", orderNo));
        if (order == null) {
            return 0;
        }
        if (order.getOstate() == OrderEnum.Ostat.FINISH.key()
                || order.getOstate() == OrderEnum.Ostat.CANCEL.key()) {
            return 1;
        }
        if (order.getOstate() == OrderEnum.Ostat.PAYING.key()) {
            return 2;
        }
        String lockKey = Account_Lock_key + order.getUid();
        try {
            if (distributeLock.tryLock(lockKey)) {
                order = forderMapper.getForderBaseData(Collections.singletonMap("sn", orderNo));
                if (order.getOstate() == OrderEnum.Ostat.CHARGING.key()) {
                    // 如果 充电中数据 已有数据 并且 状态是充电中， 则 已正常启动充电
                    if (getVoltageCurrent(orderNo) != null) {
                        return 2;
                    }
                    QueryPileGunStateParam gunParam = new QueryPileGunStateParam();
                    gunParam.setPilenum(order.getPid());
                    gunParam.setGnum(order.getGunnumber());
                    List<PileGunStateVo> gunStates = collectService.queryPileGunState(gunParam);
                    if (CollectionUtils.isEmpty(gunStates)
                            || !"4".equalsIgnoreCase(gunStates.get(0).getGunChargingState())) {
                        log.info("订单[{}]无充电中数据, 直接退款。", orderNo);
                        // 如果 充电中 没有记录数据， 则直接退款
                        order.setOstate(OrderEnum.Ostat.READING.key());
                    }
                }
                if (order.getOstate() == OrderEnum.Ostat.PAYING.key()) {
                    return 2;
                }
                if (order.getOstate() == OrderEnum.Ostat.FINISH.key()
                        || order.getOstate() == OrderEnum.Ostat.CANCEL.key()) {
                    return 1;
                }
                if (order.getOstate() != OrderEnum.Ostat.CHARGING.key()) {
                    if (!commonService.updateAccount(order, null, BigDecimal.ZERO, "订单超时退款", CommonService.ACCOUNT_OPER_TYPE_BACK)) {
                        throw new BuzzException("帐户退款，保存帐户失败");
                    }
                    // 保存订单状态为 -1失效
                    order.setOstate(OrderEnum.Ostat.CANCEL.key());
                    order.setBackMoney(order.getAmount());
                    order.setCreatetime(null);
                    int i = forderMapper.updateByPrimaryKeySelective(order);
                    if (i != 1) {
                        throw new BuzzException("帐户退款，保存订单失败");
                    }
                }
                return 1;
            }
        } finally {
            distributeLock.releaseLock(lockKey);
        }
        return 0;
    }


    /**
     * 补贴政策(重庆监管平台)
     *
     * @param supersiveId
     * @return
     */
    @Override
    public List<Subsidy> notificationRecordsAmountInfo(String supersiveId) {
        return fPileGunMapper.notificationRecordsAmountInfo(supersiveId);
    }

    /**
     * 获取当前电压 、 电流
     *
     * @param StartChargeSeq
     * @return
     */
    @Override
    public ChargeDataTemp getVoltageCurrent(String StartChargeSeq) {
        return chargeDataTempMapper.getVoltageCurrent(StartChargeSeq);
    }

    /**
     * 获取分时段的充电明细体
     * @param StartChargeSeq
     * @return
     */
    @Override
    public List<FOrderSettlementDetail> getFOrderSettlementDetailBySn(String StartChargeSeq) {
        return fOrderSettlementDetailMapper.getFOrderSettlementDetailBySn(StartChargeSeq);
    }

    @Override
    public FOrder findFOderBySn(String oderSn) {
        return forderMapper.findFOderBySn(oderSn);
    }

    @Override
    public FOrder findFOderBysuperviseSn(String superviseSn) {
        return forderMapper.findFOderBysuperviseSn(superviseSn);
    }
}
