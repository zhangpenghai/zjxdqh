package com.zjxdqh.face.param;

import com.zjxdqh.face.enums.OrderEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 请求充电参数
 * @author Yorking
 * @date 2019/08/12
 */
@Data
public class StartChargeParam {

    /**
     * 桩号
     */
    private String pileNum;
    /**
     * 枪号
     */
    private String gunNum;

    /**
     * 充电用户ID
     */
    private Integer userId;

    /**
     * 充电 锁定金额
     */
    private BigDecimal amount;


    /**
     * 创建 订单号
     */
    private String orderNo;


    /**
     * 对接方订单号
     */
    private String superviseSn;

    /**
     * 对接方ID
     */
    private Integer superviseId;

    /**
     * 帐户支付类型(0个人帐户，2企业帐户）
     */
    private Integer payType= OrderEnum.Paytype.Company.key();

}
