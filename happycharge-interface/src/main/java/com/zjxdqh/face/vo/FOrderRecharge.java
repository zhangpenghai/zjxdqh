package com.zjxdqh.face.vo;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 
 * @author code_generator
 */
@Table(name = "f_order_recharge")
public class FOrderRecharge implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer oid ; 

	/** 用户id **/
	@Column(name="uid")
	private Integer uid ; 

	/** 订单号 **/
	@Column(name="sn")
	private String sn ; 

	/** 1钱包充值 -1充电订单充值,0三方充值申请退款 **/
	@Column(name="otype")
	private Integer otype ; 

	/** 0-管理员后台操作 1-支付宝充值 2-微信充值 3-银联充值 **/
	@Column(name="platformtype")
	private Integer platformtype ; 

	/** 金额 **/
	@Column(name="amount")
	private BigDecimal amount ; 

	/**  **/
	@Column(name="remark")
	private String remark ; 

	/** 涉及到 第三方支付时，请保存第三方的订单号 **/
	@Column(name="partySN")
	private String partysn ; 

	/**  **/
	@Column(name="createtime")
	private Date createtime ; 

	/**  **/
	@Column(name="discount")
	private BigDecimal discount ; 

	/** 0-待支付，1-已支付 **/
	@Column(name="status")
	private Integer status ; 


	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	public Integer getOtype() {
		return otype;
	}
	public void setOtype(Integer otype) {
		this.otype = otype;
	}
	
	public Integer getPlatformtype() {
		return platformtype;
	}
	public void setPlatformtype(Integer platformtype) {
		this.platformtype = platformtype;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getPartysn() {
		return partysn;
	}
	public void setPartysn(String partysn) {
		this.partysn = partysn;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	

}
