package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 充电站表
 * @author code_generator
 */
@Data
@Table(name = "f_pile_site")
public class FPileSite implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	private Integer sid ;

	/**  **/
	@Column(name="sname")
	private String sname ;

	/** 副标题 **/
	@Column(name="title")
	private String title ;

	/** 充电站详情，请用html富文本方式显示 / 或者 上传图片 逗号分隔 **/
	@Column(name="detail")
	private String detail ;

	/**  **/
	@Column(name="longitude")
	private BigDecimal longitude ;

	/**  **/
	@Column(name="latitude")
	private BigDecimal latitude ;

	/**  **/
	@Column(name="sstate")
	private Integer sstate ;

	/**  **/
	@Column(name="icon")
	private String icon ;

	/**  **/
	@Column(name="socre")
	private BigDecimal socre ;

	/**  **/
	@Column(name="pcount")
	private Integer pcount ;

	/** 0-不收费 1-收取费用 **/
	@Column(name="hasparkcost")
	private byte hasparkcost ;

	/**  **/
	@Column(name="ptid")
	private Long ptid ;

	/**  **/
	@Column(name="parkremark")
	private String parkremark ;

	/** 0-不提供预约 1-提供预约 2-部分预约 **/
	@Column(name="canreserve")
	private Integer canreserve ;

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
	@Column(name="address")
	private String address ;

	/**  **/
	@Column(name="createtime")
	private Date createtime ;

	/** {0:公共,1:专用,2:个人 3.三方} **/
	@Column(name="stype")
	private Integer stype ;

	/** 专用企业id（stype==1时） **/
	@Column(name="company_id")
	private Integer companyId ;

	/** 1快乐充网络科技有限公司2三方公司 **/
	@Column(name="operatename")
	private String operatename ;

	/**  **/
	@Column(name="paymethod")
	private String paymethod ;

	/** 输入内容为：10:00~21:00 **/
	@Column(name="opentime")
	private String opentime ;

	/** 输入内容为：10:00~21:00 **/
	@Column(name="endtime")
	private String endtime ;

	/** 运营状态 **/
	@Column(name="openstate")
	private String openstate ;

	/**  **/
	@Column(name="person")
	private String person ;

	/**  **/
	@Column(name="phone")
	private String phone ;

	/**  **/
	@Column(name="buildcompany")
	private String buildcompany ;

	/**  **/
	@Column(name="runcompany")
	private String runcompany ;

	/**  **/
	@Column(name="rolecompany")
	private String rolecompany ;

	/**  **/
	@Column(name="servicescore")
	private Double servicescore ;

	/**  **/
	@Column(name="qualityscore")
	private Double qualityscore ;

	/**  **/
	@Column(name="effectivenessscore")
	private Double effectivenessscore ;

	/**  **/
	@Column(name="carlist")
	private String carlist ;

	/**  **/
	@Column(name="snum")
	private String snum ;

	/**  **/
	@Column(name="serviceprice")
	private Double serviceprice ;

	/**  **/
	@Column(name="level")
	private String level ;

	/**  **/
	@Column(name="img")
	private String img ;

	/** 是否接入监管平台（1是，0否） **/
	@Column(name="is_supervise")
	private byte isSupervise ;


	@Transient
	private List<FPile> piles;
}
