package com.zjxdqh.face.vo;

import lombok.Data;

/**
 * @outhor liusiyu
 * @create 2019-05-10-16:58
 */
@Data
public class StopChargeResultVo {

    /**
     * 充电订单号
     * 格式“运营商 ID+唯一编号”，27 字符
     */
    private  String  StartChargeSeq;
    /**
     * 充电订单状态
     */
    private  int   StartChargeSeqStat;
    /**
     * 桩号
     */
    private  String   PileNum;
    /**
     * 枪号
     */
    private  String  GunNum;
    /**
     * 成功标识
     * 0:成功； 1:失败
     */
    private int SuccStat;
    /**
     * 停止失败原因
     * 0:无；
     * 1:此设备不存在；
     * 2:此设备离线：
     * 3:设备已停止充电；
     * 4～99:自定义
     */
    private int FailReason;

 }
