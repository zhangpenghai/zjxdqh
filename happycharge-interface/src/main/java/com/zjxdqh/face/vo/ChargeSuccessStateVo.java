package com.zjxdqh.face.vo;

import lombok.Data;

/**
 * @author: wangqinmin
 * @date: 2019/5/13 10:23
 * @description: 充电成功后, 充电状态部分数据返回
 */
@Data
public class ChargeSuccessStateVo {

    /**
     * 电池剩余电量
     * 默认：0
     */
    private Double Soc;

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

}
