package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wangqinmin
 * @since 2019-09-03
 */
@Data
@Table(name = "charge_data_temp")
public class ChargeDataTemp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @Id
    @Column(name = "oid")
    private Integer oid;

    /**
     * 当前soc
     */
    @Column(name = "Soc")
    private String Soc;

    @Column(name = "RemainTime")
    private String RemainTime;

    /**
     * 当前电流
     */
    @Column(name = "Voltage")
    private BigDecimal Voltage;

    /**
     * 当前电压
     */
    @Column(name = "Current")
    private BigDecimal Current;

    /**
     * 当前充电电费
     */
    @Column(name = "electricity")
    private BigDecimal electricity;
    /**
     * 当前充电度数
     */
    @Column(name = "useele")
    private BigDecimal useele;


    /**
     * 场站id
     */
    @Column(name = "sid")
    private String sid;


    @Column(name = "whenlong")
    private String whenlong;

}
