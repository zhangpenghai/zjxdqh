package com.zjxdqh.face.param;

import lombok.Data;

/**
 * @author: wangqinmin
 * @date: 2019/5/9 11:14
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@Data
public class ChargeStateParam {

    /**
     * 充电订单号:
     * 格式“运营商 ID+唯一编号”，27 字符
     */
    private String StartChargeSeq;

    private String sn;

    private Integer superviseId;

}
