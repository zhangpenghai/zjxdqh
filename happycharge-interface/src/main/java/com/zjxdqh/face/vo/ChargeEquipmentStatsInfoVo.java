package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  充电设备统计信息
 * <p>
 *
 * @author PengWei
 * @date 2019/5/9
 */
@Data
public class ChargeEquipmentStatsInfoVo {

    /**
     * 设备编码(设备唯一编码，对同一运营商，保证唯一)
     */
    private String EquipmentID;

    /**
     * 充电设备接口累计电量(累计电量，单位 kWh，精度0.1)
     */
    private double EquipmentElectricity;

    /**
     * 充电设备接口统计信息列表(充设备的所有充电设备接口统计对象集合)
     */
    private List<ChargeConnectorStatsInfoVo> ConnectorStatsInfos = new ArrayList();
}
