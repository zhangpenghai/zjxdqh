package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 充电桩
 * @author code_generator
 */
@Data
@Table(name = "f_pile")
public class FPile implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer pid ;

	/**  **/
	@Column(name="pname")
	private String pname ;

	/**  **/
	@Column(name="detail")
	private String detail ;

	/**  **/
	@Column(name="sid")
	private Integer sid ;

	/**  **/
	@Column(name="longitude")
	private BigDecimal longitude ;

	/**  **/
	@Column(name="latitude")
	private BigDecimal latitude ;

	/**  **/
	@Column(name="support")
	private Double support ;

	/**  **/
	@Column(name="icon")
	private String icon ;

	/**  **/
	@Column(name="usecount")
	private Integer usecount ;

	/** -1停用0正常1故障4预设5审核未通过10删除 **/
	@Column(name="pstate")
	private Integer pstate ;

	/**  **/
	@Column(name="guncount")
	private Integer guncount ;

	/**  **/
	@Column(name="buildstate")
	private Integer buildstate ;

	/**  **/
	@Column(name="gainmode")
	private Integer gainmode ;

	/**  **/
	@Column(name="createtime")
	private Date createtime ;

	/**  **/
	@Column(name="haslock")
	private Integer haslock ;

	/**  **/
	@Column(name="spacecount")
	private Integer spacecount ;

	/**  **/
	@Column(name="provinceid")
	private Integer provinceid ;

	/**  **/
	@Column(name="cityid")
	private Integer cityid ;

	/**  **/
	@Column(name="areaid")
	private Integer areaid ;

	/**  **/
	@Column(name="voltage")
	private String voltage ;

	/**  **/
	@Column(name="current")
	private String current ;

	/**  **/
	@Column(name="power")
	private String power ;

	/**  **/
	@Column(name="address")
	private String address ;

	/**  **/
	@Column(name="puid")
	private Integer puid ;

	/**  **/
	@Column(name="trialStatus")
	private Integer trialstatus ;

	/** 1快充，0慢充 **/
	@Column(name="ptype")
	private Integer ptype ;

	/**  **/
	@Column(name="potype")
	private Integer potype ;

	/**  **/
	@Column(name="opentime")
	private String opentime ;

	/**  **/
	@Column(name="endtime")
	private String endtime ;

	/**  **/
	@Column(name="comunicatestate")
	private Integer comunicatestate ;

	/**  **/
	@Column(name="successcount")
	private Integer successcount ;

	/**  **/
	@Column(name="failcount")
	private Integer failcount ;

	/**  **/
	@Id
	private String pilenum ;

	/**  **/
	@Column(name="model")
	private String model ;

	/**  **/
	@Column(name="manufacture")
	private String manufacture ;

	/**  **/
	@Column(name="pileNumLength")
	private Integer pilenumlength ;

	/**  **/
	@Column(name="upt_time")
	private Date uptTime ;



}
