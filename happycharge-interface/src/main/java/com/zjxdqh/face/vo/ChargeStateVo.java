package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: wangqinmin
 * @date: 2019/5/9 11:32
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@Data
public class ChargeStateVo {

    /**
     * 充电订单号:
     * 格式“运营商 ID+唯一编号”，27 字符
     */
    private String StartChargeSeq;

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
     * 充电设备接口编码:
     * 参见《成都市新能源汽车及充电设施信管理平台互联互通技术对接实施细则第 2 部分：公共信息交换规范》
     */
    private String ConnectorID;

    /**
     * 充电设备接口状态:
     * 1：空闲2：占用（未充电）3：占用（充电中）4：占用（预约锁定）255：故障
     */
    private Integer ConnectorStatus;

    /**
     * A 相电流: 必填参数
     * 单位：A，默认：0 含直流(输出)
     */
    private Double CurrentA;

    /**
     * B 相电流: 非必填参数
     * 单位：A，默认：0
     */
    private Double CurrentB;

    /**
     * C 相电流: 非必填参数
     * 单位：A，默认：0
     */
    private Double CurrentC;

    /**
     * A 相电压: 必填参数
     * 单位：V，默认：0 含直流(输出)
     */
    private Double VoltageA;

    /**
     * B 相电压: 非必填参数
     * 单位：V，默认：0
     */
    private Double VoltageB;

    /**
     * C 相电压: 非必填参数
     * 单位：V，默认：0
     */
    private Double VoltageC;

    /**
     * 电池剩余电量
     * 默认：0
     */
    private Double Soc;

    /**
     * 开始充电时间
     * 格式“yyyy-MM-dd HH:mm:ss”
     */
    private String StartTime;

    /**
     * 启动方式
     * 用户开启充电的方式
     * 0: 未知
     * 1: 市级平台启动
     * 2：有卡启动
     * 3：其他无卡启动
     */
    private Integer ChargeModel;

    /**
     * 本次采样时间
     * 格式“yyyy-MM-dd HH:mm:ss”
     */
    private Date EndTime;

    /**
     * 累计充电量:
     * 单位：度，小数点后 2 位
     */
    private Double TotalPower;

    /**
     * 累计电费
     * 单位：元，小数点后 2 位；若无该类信息默认填 0；
     */
    private Double ElecMoney;

    /**
     * 累计服务费
     * 单位：元，小数点后 2 位；若无该类信息默认填 0；
     */
    private Double SeviceMoney;

    /**
     * 累计总金额
     * 单位：元，小数点后 2 位；若无该类信息默认填 0；
     */
    private Double TotalMoney;

    /**
     * 时段数 N
     * 范围：0～32
     */
    private Integer SumPeriod;

    /**
     * 充电明细信息
     * <p>
     * 单时段充电明细信息，见 6.2.4
     */
    private List<ChargeOrderDetailVo> ChargeDetails;

}
