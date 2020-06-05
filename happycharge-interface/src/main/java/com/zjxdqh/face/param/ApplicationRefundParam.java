package com.zjxdqh.face.param;

import lombok.Data;

/**
 * 确认退款申请 参数
 * @author chenshunhua
 * @date 2019/09/10
 */
@Data
public class ApplicationRefundParam {

    /**
     * 充电用户ID
     */
    private Integer userId;
    /**
     *
     * 退款原因
     *  1-不想使用APP
     2-不再使用电车
     *
     */
    String refundReasonId;
    /**
     * 退款说明
     *
     */
    String refundRemarks;

    /**
     * 退款金额
     *
     */
    double refundAmount;



}


