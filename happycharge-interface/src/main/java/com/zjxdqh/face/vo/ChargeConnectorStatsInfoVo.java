package com.zjxdqh.face.vo;

import lombok.Data;

/**
 * <p>
 *  充电设备接口统计信息
 * <p>
 *
 * @author PengWei
 * @date 2019/5/10
 */
@Data
public class ChargeConnectorStatsInfoVo {

    /**
     * 充电设备接口编码(同一运营商内唯一)
     */
    private String ConnectorID;

    /**
     * 充电设备接口累计电量(累计电量，单位 kWh，精度0.1)
     */
    private double ConnectorElectricity;
}
