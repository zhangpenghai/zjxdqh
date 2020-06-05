package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  充电站统计信息
 * <p>
 *
 * @author PengWei
 * @date 2019/5/10
 */
@Data
public class ChargeStationStatsInfoVo {

    /**
     * 充电站 ID
     */
    private String StationID;

    /**
     * 统计的开始时间
     */
    private Date StartTime;

    /**
     * 统计的结束时间
     */
    private Date EndTime;

    /**
     * 充电站累计电量（累计电量，单位kWh，精度 0.1）
     */
    private double StationElectricity;

    /**
     * 充电设备统计信息列表（充电站中所有充电设备的统计对象集合）
     */
    private List<ChargeEquipmentStatsInfoVo> EquipmentStatsInfos = new ArrayList<>();
}
