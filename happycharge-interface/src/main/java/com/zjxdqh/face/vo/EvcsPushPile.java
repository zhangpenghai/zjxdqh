package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author: liuhong
 * @date: 2020/5/9
 * @description: 监管品台需要申报的设备
 */
@Data
@Table(name = "evcs_push_pile")
public class EvcsPushPile  implements java.io.Serializable{
    /**
     * 桩号
     */
    private String pilenum;

    /**
     * 枪号
     */
    private String gunnumber;
}
