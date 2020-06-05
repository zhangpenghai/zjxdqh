package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;


/**
 * 注意:注解只能加在属性字段上才会生效!
 *
 * @author code_generator
 */
@Data
@Table(name = "f_user_setting")
public class FUserSetting implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户配置表主键
     **/
    @Id
    private String id;

    /**
     * 用户id
     **/
    @Column(name = "uid")
    private Integer uid;

    /**
     * app账户扣费设置(默认支付方式)
     * 0:个人账户付费
     * 1：企业账户付费
     **/
    @Column(name = "default_pay_method")
    private Integer defaultPayMethod;

    /**
     * 是否自动支付 0：自动支付  1：手动支付(默认)
     **/
    @Column(name = "autopay")
    private Integer autopay;

    /**
     * 订单 默认充值金额
     */
    @Column(name = "default_recharge_value")
    private BigDecimal defaultRechargeValue;

}
