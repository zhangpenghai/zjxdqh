package com.zjxdqh.happchargeserver.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @outhor liusiyu
 * @create 2019-05-13-10:23
 */
@Data
@Table(name = "f_order")
public class StopChargeVo {
    /**
     * 充电订单号
     * 格式“运营商 ID+唯一编号”，27 字符
     */
    @Column(name = "sn")
    private  String  StartChargeSeq;
    /**
     * 充电订单状态
     * 1：启动中
     * 2：充电中
     * 3：停止中
     * 4：已结束
     * 5：未知
     */
    @Column(name="ostate")
    private  int   StartChargeSeqStat;
    /**
     * 桩号
     */
    @Column(name="pid")
    private  String  PileNum;
    /**
     * 枪号
     */
    @Column(name="gunnumber")
    private  String  GunNum;
    /**
     * 成功标识
     * 0:成功； 1:失败
     */
    @Column(name="ostate")
    private int SuccStat;
    /**
     * 停止失败原因
     * 0:无； 1:此设备不存在； 2:此设备离线： 3:设备已停止充电； 4～99:自定义
     */
    @Column(name="end_reason")
    private int FailReason;


}
