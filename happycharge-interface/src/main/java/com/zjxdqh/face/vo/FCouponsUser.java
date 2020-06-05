package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 用户领用的优惠券
 * @author code_generator
 */
@Table(name = "f_coupons_user")
@Data
public class FCouponsUser implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	private Integer couponsUserId ;

	/** 用户ID **/
	@Id
	private Integer userId ; 

	/** 优惠券ID **/
	@Column(name="coupons_id")
	private Integer couponsId ; 

	/** 优惠券红包金额 **/
	@Column(name="coupons_amount")
	private BigDecimal couponsAmount ; 

	/** 生效时间 **/
	@Column(name="effect_time")
	private Date effectTime ; 

	/** 过期时间 **/
	@Column(name="expire_time")
	private Date expireTime ; 

	/** 状态，-1过期，1有效，2已使用 **/
	@Column(name="coupons_user_stat")
	private Integer couponsUserStat ; 

	/**  **/
	@Column(name="create_time")
	private Date createTime ; 


}
