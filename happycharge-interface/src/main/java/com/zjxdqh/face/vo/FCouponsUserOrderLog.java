package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 充电订单优惠券使用日志
 * @author code_generator
 */
@Table(name = "f_coupons_user_order_log")
@Data
public class FCouponsUserOrderLog implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	private Integer id ;

	/** 用户绑定的优惠券ID **/
	@Column(name="coupon_user_id")
	private Integer couponUserId ; 

	/** 充电订单ID **/
	@Column(name="sn")
	private String  sn ;

	/** 订单分时结算ID **/
	@Column(name="order_detail_id")
	private Integer orderDetailId ; 

	/** 优惠前订单总金额 **/
	@Column(name="bef_order_amount")
	private BigDecimal befOrderAmount ; 

	/** 应用优惠前服务费 **/
	@Column(name="bef_service_money")
	private BigDecimal befServiceMoney ; 

	/** 应用优惠前电费 **/
	@Column(name="bef_ele_money")
	private BigDecimal befEleMoney ; 

	/** 应用优惠后服务费 **/
	@Column(name="aft_service_money")
	private BigDecimal aftServiceMoney ; 

	/** 应用优惠后电费 **/
	@Column(name="aft_ele_money")
	private BigDecimal aftEleMoney ; 

	/** 应用优惠后订单总金额 **/
	@Column(name="aft_order_amount")
	private BigDecimal aftOrderAmount ; 

	/**  **/
	@Column(name="create_time")
	private Date createTime ; 


}
