package com.zjxdqh.happchargeserver.model;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 
 * @author code_generator
 */
@Table(name = "f_account_info")
@Data
public class FAccountInfo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	private Integer id ;

	/** 用户把流水号提供过来就可以知道订单信息了，可以追溯订单问题。流水号生成规则：（前缀_）+年月日时分秒毫秒 + 6位随机数 （字符串拼接）,前缀目前暂定拼音首字母方便查阅（CD=充电,TK_ =退款 YY_=预约 以此类推) **/
	@Column(name="sn")
	private String sn ; 

	/**  **/
	@Column(name="uid")
	private Integer uid ; 

	/**  **/
	@Column(name="oid")
	private Integer oid ; 

	/** 1-充电订单 2-预约订单 3-提现订单 4-退款订单 5-充值订单 6-扣款订单（这个状态只有管理员在后台操作扣用户款才会产生） **/
	@Column(name="otype")
	private Integer otype ; 

	/** 0支付宝，1微信，2个人，3企业 **/
	@Column(name="paytype")
	private Integer paytype ; 

	/**  **/
	@Column(name="amount")
	private BigDecimal amount ; 

	/**  **/
	@Column(name="balanceBef")
	private BigDecimal balancebef ; 

	/**  **/
	@Column(name="balanceAft")
	private BigDecimal balanceaft ; 

	/**  **/
	@Column(name="accountBef")
	private BigDecimal accountbef ; 

	/**  **/
	@Column(name="accountAft")
	private BigDecimal accountaft ; 

	/**  **/
	@Column(name="cashBef")
	private BigDecimal cashbef ; 

	/**  **/
	@Column(name="cashAft")
	private BigDecimal cashaft ; 

	/**  **/
	@Column(name="createtime")
	private Date createtime ; 

	/** 一般显示 为 充电订单，预约订单，不用多表查询得到订单类型 **/
	@Column(name="title")
	private String title ; 

	/** 用户备注字段暂留，考虑后期用户自己方便找到自己的流水 **/
	@Column(name="userremark")
	private String userremark ; 

	/**  **/
	@Column(name="remark")
	private String remark ; 

	/** 操作人ID **/
	@Column(name="operatorId")
	private Integer operatorid ; 


}
