package com.zjxdqh.face.vo;

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
@Data
@Table(name = "f_refund_record")
public class FRefundRecord implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/** id **/
	@Id
	private String id ;

	/** 申请退款用户id **/
	@Column(name="uid")
	private Integer uid ; 

	/** 退款金额 **/
	@Column(name="refundAmount")
	private BigDecimal refundamount ; 

	/** 退款原因id **/
	@Column(name="refundReasonId")
	private String refundreasonid ; 

	/** 退款其他原因 **/
	@Column(name="othReason")
	private String othreason ; 

	/** 状态 0-退款中，1-退款成功，2-退款失败 **/
	@Column(name="status")
	private String status ; 

	/** 退款失败原因 **/
	@Column(name="refundFailReason")
	private String refundfailreason ; 

	/** 创建时间 **/
	@Column(name="createtime")
	private Date createtime ; 

	/** 退款成功时间 **/
	@Column(name="successtime")
	private Date successtime ; 

	/** 退款失败时间 **/
	@Column(name="failtime")
	private Date failtime ;


	/** 退款原因 **/
	@Column(name="refundReason")
	private String refundReason;
	

}
