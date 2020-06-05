package com.zjxdqh.face.vo;

import lombok.Data;

/**
 * @author: wangqinmin
 * @date: 2019/8/9 10:30
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@Data
public class PolicyInfo {

    /**
     * 时段起始时间点（格式：HHmmss ,6字符）
     */
    private String StartTime;

    /**
     * 时段电费 （小数点后4位）
     */
    private Double ElecPrice;

    /**
     * 时段服务费 （小数点后4位）
     */
    private Double ServicePrice;
}
