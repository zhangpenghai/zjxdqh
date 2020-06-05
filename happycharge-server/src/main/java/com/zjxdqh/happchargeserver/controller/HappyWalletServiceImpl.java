package com.zjxdqh.happchargeserver.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjxdqh.face.common.UUIDUtil;
import com.zjxdqh.face.enums.RefundReasonEnums;
import com.zjxdqh.face.enums.RefundStatusEnums;
import com.zjxdqh.face.param.*;
import com.zjxdqh.face.service.HappyWalletService;
import com.zjxdqh.face.vo.*;
import com.zjxdqh.face.vo.user.FAccount;
import com.zjxdqh.happchargeserver.mapper.FAccountInfoMapper;
import com.zjxdqh.happchargeserver.mapper.FAccountMapper;
import com.zjxdqh.happchargeserver.mapper.FOrderRechargeMapper;
import com.zjxdqh.happchargeserver.mapper.FRefundRecordMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

/**
 * 个人帐户钱包操作类
 *
 * @author Yorking
 * @date 2019/05/09
 */
@RestController
@Log4j2
public class HappyWalletServiceImpl implements HappyWalletService {

    @Resource
    private FAccountMapper fAccountMapper;

    @Resource
    private FAccountInfoMapper fAccountInfoMapper;

    @Resource
    private FOrderRechargeMapper rechargeMapper;

    @Resource
    private FRefundRecordMapper fRefundRecordMapper;


    /**
     * 根据用户uid查询用户     *
     *
     * @param uid
     * @return
     */
    @Override
    public FAccount getFaccount(Integer uid) {
        return fAccountMapper.getOne(Collections.singletonMap("uid", uid));
    }

    /**
     * 获取用户账单信息
     *
     * @param date    按月查询时间  "2019-09"
     * @param page    页数
     * @param typeOne 个人账户查询，typeOne不为空
     * @param typeTwo 企业账户查询，typeTwo不为空
     * @return
     */
    @Override
    public PageInfo<UserBillVo> getUserBill(Integer uid, String date, Integer page, Integer typeOne, Integer typeTwo) {
        return PageHelper.startPage(page, 10, true, false).doSelectPageInfo(() -> fAccountInfoMapper.getUserBill(uid, date, page, typeOne, typeTwo));
    }

    /**
     * 获取用户账单信息
     *
     * @param date    按月查询时间  "2019-09"
     * @param page    页数
     * @param typeOne 个人账户查询，typeOne不为空
     * @param typeTwo 企业账户查询，typeTwo不为空
     * @return
     */
    @Override
    public UserBillTotalVo getUserBillTotal(Integer uid, String date, Integer page, Integer typeOne, Integer typeTwo) {

        // 查询sum
        BigDecimal totalRecharge = fAccountInfoMapper.getTotalRecharge(uid, date, typeOne, typeTwo);
        BigDecimal totalConsume = fAccountInfoMapper.getTotalConsume(uid, date, typeOne, typeTwo);

        UserBillTotalVo userBillTotalVo = new UserBillTotalVo();
        userBillTotalVo.setTotalRecharge(totalRecharge == null ? BigDecimal.ZERO : totalRecharge);
        userBillTotalVo.setTotalConsume(totalConsume == null ? BigDecimal.ZERO : totalConsume);
        return userBillTotalVo;
    }

    @Override
    public PageInfo<RechargeRecordVo> getRechargeRecord(RechargeOrderParam param) {
        return PageHelper.startPage(param.getPageNo(), param.getPageSize(), true, false)
                .doSelectPageInfo(() -> rechargeMapper.getPageList(param));
    }

    @Override
    public QueryRefundVo queryRefund(QueryRefundParam param) {

        QueryRefundVo vo = fAccountMapper.queryRefund(param.getUserId());

        if(vo.getRefundAmount().doubleValue()<0)
        {
            vo.setRefundAmount(new BigDecimal("0.00"));
        }
        vo.setRefundNote("快乐充APP仅支持可退金额全额退。不可退金额包含参加活动充值获得优惠卷的余额。申请成功后金额将在3-7个工作日退还至原支付账户，本规则的解释权归快乐充所有。");

        return vo;
    }

    @Override
    public boolean applicationRefund(ApplicationRefundParam param) {

        //保存确认申请退款记录
        FRefundRecord fRefundRecord = new FRefundRecord();
        fRefundRecord.setId(UUIDUtil.getUUID());
        fRefundRecord.setUid(param.getUserId());
        BigDecimal bigDecimal = new BigDecimal(param.getRefundAmount());
        fRefundRecord.setRefundamount(bigDecimal);
        fRefundRecord.setRefundreasonid(param.getRefundReasonId());
        fRefundRecord.setRefundReason(RefundReasonEnums.getRefundReason(param.getRefundReasonId()));
        fRefundRecord.setOthreason(param.getRefundRemarks());
        fRefundRecord.setStatus(RefundStatusEnums.KV_0.getKey());
        fRefundRecord.setCreatetime(new Date());
        fRefundRecordMapper.insert(fRefundRecord);

        RefundAmountParam amountParam = new RefundAmountParam();
        amountParam.setUserId(param.getUserId());
        amountParam.setRefundAmount(param.getRefundAmount());
        fAccountMapper.updateAmountById(amountParam);

        return true;
    }

    @Override
    public PageInfo<RefundRecordVo> queryRefundRecord(QueryRefundRecordParam param) {
        return PageHelper.startPage(param.getPageNo(), param.getPageSize(), true, false)
                .doSelectPageInfo(() -> fRefundRecordMapper.getPageList(param.getUserId()));
    }
}
