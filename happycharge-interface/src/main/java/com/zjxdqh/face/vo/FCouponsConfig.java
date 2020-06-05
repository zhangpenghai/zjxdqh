package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 优惠券应用参数
 * @author code_generator
 */
@Table(name = "f_coupons_config")
@Data
public class FCouponsConfig implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	private Integer couponsConfigId ;

	/** 优惠券ID，表f_coupons **/
	@Column(name="coupon_id")
	private Integer couponId ; 

	/** 配置参数名称 **/
	@Column(name="coupon_key")
	private String couponKey ; 

	/** 参数类型0字符串，1整数，2浮点数，3时间，4日期 **/
	@Column(name="coupon_valtype")
	private Integer couponValtype ; 

	/** 参数值 1 **/
	@Column(name="coupon_val1")
	private String couponVal1 ; 

	/** 参数值 2  **/
	@Column(name="coupon_val2")
	private String couponVal2 ; 

	/** 创建时间 **/
	@Column(name="create_time")
	private Date createTime ; 

	/**  **/
	@Column(name="update_time")
	private Date updateTime ; 

}
