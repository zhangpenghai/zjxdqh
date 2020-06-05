package com.zjxdqh.face.param;

import lombok.Data;

/**
 *  确认退款金额
 */
@Data
public class RefundAmountParam {

    /**
     * 充电用户ID
     */
    private int userId;

    /**
     * 退款金额
     *
     */
    private double refundAmount;



}
