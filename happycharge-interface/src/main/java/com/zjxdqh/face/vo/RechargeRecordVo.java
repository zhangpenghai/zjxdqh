package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author: chenshunhua
 * @date: 2019/09/18
 * @description:  充值记录返回值
 */
@Data
public class RechargeRecordVo {


    /**
     *
     * 第三方订单号
     */
    private String partySn;
    /**
     *
     * 充值类型
     *
     * 1-支付宝充值 2-微信充值
     *
     */
    private int rechargeType;

    /**
     * 充值成功时间
     *
     */
    private Date rechargeTime;

    /**
     *
     * 充值金额
     *
     */
    private double amount;

}
