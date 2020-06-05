package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;

/**
 * 注意:注解只能加在属性字段上才会生效!
 * 中电联协议 密钥信息表
 * @author code_generator
 */
@Data
@Table(name = "supersive_info")
public class SupersiveInfo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	private Integer supersiveId ;

	/**
	 * 平台组织代码
	 */
	@Column(name="org_id")
	private String orgId;
	/**  **/
	@Column(name="operator_id")
	private String operatorId ;

	/**  **/
	@Column(name="operator_name")
	private String operatorName ;

	/**  **/
	@Column(name="operator_secret")
	private String operatorSecret ;

	/**  **/
	@Column(name="sig_secret")
	private String sigSecret ;

	/**  **/
	@Column(name="data_secret")
	private String dataSecret ;

	/**  **/
	@Column(name="data_secret_iv")
	private String dataSecretIv ;

	@Column(name = "operator_url")
	private String operatorUrl;

	@Column(name = "account_user_id")
	private String accountUserId;

	/**  **/
	@Column(name="create_time")
	private Date createTime ;

	/** 0禁用，1启用 **/
	@Column(name="operator_stat")
	private Integer operatorStat ;


	/**
	 * 1 监管平台， 0 普通对接方
	 */
	@Column(name="regulatory")
	private Integer regulatory;

}

