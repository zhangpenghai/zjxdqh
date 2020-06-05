package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 用户APP长登录
 * @author code_generator
 */
@Data
@Table(name = "f_user_app_login")
public class FUserAppLogin implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	private Integer id ;

	/**  **/
	@Column(name="token")
	private String token ; 

	/**  **/
	@Column(name="logintime")
	private Date logintime ; 

	/**  **/
	@Column(name="timeout")
	private Date timeout ; 

	/**  **/
	@Column(name="uid")
	private Integer uid ; 

	/**  **/
	@Column(name="uname")
	private String uname ; 

	/**  **/
	@Column(name="loginIP")
	private String loginip ; 

	/**  **/
	@Column(name="pwd")
	private String pwd ; 

	/**  **/
	@Column(name="timestamp")
	private String timestamp ; 

}
