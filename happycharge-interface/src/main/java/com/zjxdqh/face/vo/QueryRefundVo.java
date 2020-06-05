package com.zjxdqh.face.vo;

import com.zjxdqh.tools.annon.NumberScale;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: chenshunhua
 * @date: 2019/09/12
 * @description:  申请退款首页
 */
@Data
public class QueryRefundVo {


    /**
     * 可退金额
     *
     */
    @NumberScale(2)
    private BigDecimal refundAmount;

    /**
     *
     * 不可退金额
      */
    @NumberScale(2)
    private BigDecimal noRefundAmount;

    /**
     *
     * 退款说明
     *
     */
    String  refundNote;


}
