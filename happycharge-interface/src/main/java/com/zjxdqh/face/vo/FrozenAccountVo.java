package com.zjxdqh.face.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: wangqinmin
 * @date: 2019/9/11 11:19
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@Data
public class FrozenAccountVo implements Serializable {

    private static final long serialVersionUID = -4135273560229737325L;
    /**
     * 个人冻结金额
     */
    private BigDecimal aloneFrozenBalance;

    /**
     * 企业冻结金额
     */
    private BigDecimal enterpriseFrozenBalance;

}
