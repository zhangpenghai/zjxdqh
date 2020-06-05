package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author: wangqinmin
 * @date: 2019/5/13 10:28
 * @description: 充电状态接口：数据库一定能返回的数据
 */
@Data
public class ChargeStateBaseVo {

    /**
     * 订单编号
     */
    private String sn;

    /**
     * 充电订单号:
     * 格式“运营商 ID+唯一编号”，27 字符
     */
    private String StartChargeSeq;

    /**
     * 充电设备接口状态
     */
    private Integer ConnectorStatus;

    /**
     * 本次采样时间
     * 格式“yyyy-MM-dd HH:mm:ss”
     */
    private Date EndTime;

    /**
     * 充电订单状态:
     * 1：启动中
     * 2：充电中
     * 3：停止中
     * 4：已结束
     * 5：未知
     */
    private Integer StartChargeSeqStat;

    /**
     * 开始充电时间
     * 格式“yyyy-MM-dd HH:mm:ss”
     */
    private Date StartTime;

    /**
     * 启动方式
     * 用户开启充电的方式queryEquipChargeStatus
     * 0: 未知
     * 1: 市级平台启动
     * 2：有卡启动
     * 3：其他无卡启动
     */
    private Integer ChargeModel;

    /**
     * 桩编号
     */
    private String pid;

    /**
     * 枪号
     */
    private String gunnumber;

    /**
     * 总电量
     */
    private Double useEle;

    /**
     * 结束原因
     */
    private Integer endReason;

    /**
     * 退款金额
     */
    private Double backMoney;

    /**
     * 预付费金额
     */
    private Double amount;

    /**
     * 车辆VIN码
     */
    private String vin;


    /**
     * 创建时间
     * 格式“yyyy-MM-dd HH:mm:ss”
     */
    private Date createTime;


    /**  **/
    private String superviseSn;

    private Integer superviseId;

    private Integer userId;
}
