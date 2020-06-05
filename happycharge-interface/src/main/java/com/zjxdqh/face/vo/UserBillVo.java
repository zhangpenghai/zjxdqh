package com.zjxdqh.face.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: wangqinmin
 * @date: 2019/9/20 17:46
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@Data
public class UserBillVo implements Serializable {

    /**
     *  标题
     */
    private String title;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 订单时间
     */
    private String createtime;

    /**
     * 账单状态：1 充值  2消费
     */
    private Integer types;

}
