package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;

/**
 * 充电明细信息体
 *
 * @author Yorking
 * @date 2019/05/08
 */
@Data
public class ChargeOrderDetailVo {

    /**
     * 充电开始时间
     */
    private Date DetailStartTime;
    /**
     * 充电结束时间
     */
    private Date DetailEndTime;
    /**
     * 时段电价
     * 小数点后 4 位；若无该类信息默认填 0；
     */
    private Double ElecPrice;
    /**
     * 时段服务费价格
     * 小数点后 4 位；若无该类信息默认填 0；
     */
    private Double SevicePrice;
    /**
     * 时段 充电量
     * 单位：度，小数点后 2 位
     */
    private Double DetailPower;
    /**
     * 时段 电费
     * 小数点后 2 位；若无该类信息默认填 0；
     */
    private Double DetailElecMoney;
    /**
     * 时段 服务费
     * 小数点后 2 位；若无该类信息默认填 0；
     */
    private Double DetailSeviceMoney;


}
