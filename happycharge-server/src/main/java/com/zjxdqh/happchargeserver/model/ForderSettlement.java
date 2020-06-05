package com.zjxdqh.happchargeserver.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author: wangqinmin
 * @date: 2019/5/13 10:47
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@Data
@Table(name = "f_order_settlement")
public class ForderSettlement {

    /**
     * 订单编号
     */
    @Column(name = "sn")
    private String sn;
    /**
     * 总费用
     * 单位：元，小数点后 2 位；若无该类信息
     * 默认填 0；
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    /**
     * 总电费
     * 单位：元，小数点后 2 位；若无该类信息
     * 默认填 0；
     */
    @Column(name = "ele_amount")
    private BigDecimal eleAmount;
    /**
     * 总服务费
     * 单位：元，小数点后 2 位；若无该类信息
     * 默认填 0；
     */
    @Column(name = "service_amount")
    private BigDecimal serviceAmount;

    /**
     * 充电结束电量
     */
    @Column(name = "esoc")
    private BigDecimal esoc;
    /**
     * 累计充电量
     * 单位：元，小数点后 2 位；若无该类信息
     *
     */
    @Column(name = "useele")
    private BigDecimal useele;

}
