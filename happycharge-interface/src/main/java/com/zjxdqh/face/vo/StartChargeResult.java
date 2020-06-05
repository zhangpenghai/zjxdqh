package com.zjxdqh.face.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 启动充电结果
 *
 * @author Yorking
 * @date 2019/08/12
 */
@Data
public class StartChargeResult {


    /**
     * 订单ID
     */
    private Integer oid;
    /**
     * 订单号
     */
    private String sn;
    /**
     * 订单状态
     */
    private Integer orderStat;
    /**
     * 失败原因
     */
    private String failReason;
    /**
     * 订单金额
     */
    private BigDecimal amount;

}
