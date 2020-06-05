package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: wangqinmin
 * @date: 2019/8/20 11:30
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@Data
@Table(name = "f_pile")
public class Subsidy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="ConnectorID")
    private String ConnectorID;

    @Column(name="EquipmentID")
    private String EquipmentID;

    @Column(name="StationID")
    private String StationID;

    @Column(name="StakeType")
    private String StakeType;
}
