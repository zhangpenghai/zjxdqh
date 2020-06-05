package com.zjxdqh.face.vo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: wangqinmin
 * @date: 2019/9/20 18:04
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@Data
public class UserBillTotalVo implements Serializable {

    /**
     * 总充值时间
     */
    private BigDecimal totalRecharge = BigDecimal.ZERO;

    /**
     * 总消费时间
     */
    private BigDecimal totalConsume = BigDecimal.ZERO;

    /**
     * 账单信息
     */
    private PageInfo<UserBillVo> userBillVos;
}
