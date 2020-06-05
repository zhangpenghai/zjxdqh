package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 新 优惠券
 * @author code_generator
 */
@Table(name = "f_coupons")
@Data
public class FCoupons implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	private Integer id ;

	/** 优惠券名称 **/
	@Column(name="coupon_name")
	private String couponName ; 

	/** 优惠券描述 **/
	@Column(name="coupon_desc")
	private String couponDesc ; 

	/** 优惠类型:1现金券,2 抵用券 3 折扣券 4 满减券 **/
	@Column(name="coupon_type")
	private Integer couponType ; 

	/** 优惠数值 **/
	@Column(name="coupon_val")
	private BigDecimal couponVal ; 

	/** 优惠活动起始时间 **/
	@Column(name="start_time")
	private Date startTime ; 

	/** 优惠活动终止时间 **/
	@Column(name="expire_time")
	private Date expireTime ; 

	/** 优惠状态 -1禁用，0待用，1使用中 **/
	@Column(name="coupon_stat")
	private Integer couponStat ; 

	/**  **/
	@Column(name="create_time")
	private Date createTime ; 


}
