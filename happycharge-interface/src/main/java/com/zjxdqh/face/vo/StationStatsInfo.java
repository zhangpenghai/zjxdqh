package com.zjxdqh.face.vo;

import lombok.Data;

/**
 * <p>
 *    充电站统计数据
 * <p>
 *
 * @author PengWei
 * @date 2019/5/13
 */
@Data
public class StationStatsInfo {

    /**
     * 充电站id
     */
    private Integer siteNum;

    /**
     * 桩号
     */
    private String pileNum;

    /**
     * 枪号
     */
    private String gunNum;

    /**
     * 充电量
     */
    private double useEle;
}
