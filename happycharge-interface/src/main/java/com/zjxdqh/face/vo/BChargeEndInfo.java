package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author: liuhong
 * @date: 2020/4/21
 * @description: 充电结束采集信息实体
 */
@Data
@Table(name = "b_charge_end_info")
public class BChargeEndInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 电表总起值
     */
    @Column(name = "init_kilowatt")
    private Integer initKilowatt;

    /**
     * 电表总止值
     */
    @Column(name = "end_kilowatt")
    private Integer endKilowatt;
}
