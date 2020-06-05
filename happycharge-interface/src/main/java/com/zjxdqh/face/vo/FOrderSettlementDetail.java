package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 结算订单明细
 * </p>
 *
 * @author wangqinmin
 * @since 2019-09-05
 */
@Data
@Table(name = "f_order_settlement_detail")
public class FOrderSettlementDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "settle_detail_id")
    private Integer settleDetailId;

    @Column(name = "sn")
    private String sn;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "power")
    private BigDecimal power;

    @Column(name = "service_price")
    private BigDecimal servicePrice;

    @Column(name = "ele_price")
    private BigDecimal elePrice;

    @Column(name = "sprice")
    private BigDecimal sprice;

    @Column(name = "eprice")
    private BigDecimal eprice;

    @Column(name = "service_money")
    private BigDecimal serviceMoney;

    @Column(name = "ele_money")
    private BigDecimal eleMoney;

    @Column(name = "discount_type")
    private Integer discountType;

    @Column(name = "discount_value")
    private BigDecimal discountValue;

    @Column(name = "create_time")
    private Date createTime;

}
