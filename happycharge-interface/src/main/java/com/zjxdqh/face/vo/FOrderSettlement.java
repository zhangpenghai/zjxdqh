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
 * 订单结算结果信息表
 * @author code_generator
 */
@Data
@Table(name = "f_order_settlement")
public class FOrderSettlement implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	/**  **/
	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id ; 

	/**  **/
	@Column(name="sn")
	private String sn ; 

	/** 总费用 **/
	@Column(name="total_amount")
	private BigDecimal totalAmount ; 

	/** 总电费 **/
	@Column(name="ele_amount")
	private BigDecimal eleAmount ; 

	/** 总服务费 **/
	@Column(name="service_amount")
	private BigDecimal serviceAmount ; 

	/** 充电起始电量 **/
	@Column(name="init_kilowatt")
	private BigDecimal initKilowatt ; 

	/** 充电结束电量 **/
	@Column(name="end_kilowatt")
	private BigDecimal endKilowatt ; 

	/** 充电结束数据关系ID **/
	@Column(name="end_charge_id")
	private String endChargeId ; 

	/** 服务费折扣模板类型（1比例，2固定金额） **/
	@Column(name="discount_type")
	private Integer discountType ; 

	/** 折扣值 （金额或百分比） **/
	@Column(name="discount_value")
	private BigDecimal discountValue ; 

	/**  **/
	@Column(name="create_time")
	private Date createTime ; 

	/** 创建用户ID **/
	@Column(name="create_uid")
	private Integer createUid ; 

	/**  **/
	@Column(name="modify_time")
	private Date modifyTime ; 

	/** 修改用户ID **/
	@Column(name="modify_uid")
	private Integer modifyUid ; 

	/** 参考总费用 **/
	@Column(name="refer_total_amount")
	private BigDecimal referTotalAmount ; 

	/** 参考电费 **/
	@Column(name="refer_ele_amount")
	private BigDecimal referEleAmount ; 

	/** 参考服务费 **/
	@Column(name="refer_service_amount")
	private BigDecimal referServiceAmount ;


	/** 原始总费用 **/
	@Column(name="original_total_amount")
	private BigDecimal originalTotalAmount ;

	/** 原始电费 **/
	@Column(name="original_ele_amount")
	private BigDecimal originalEleAmount ;

	/** 原始服务费 **/
	@Column(name="original_service_amount")
	private BigDecimal originalServiceAmount ;

	/** 优惠总金额 **/
	@Column(name="coupons_total_amount")
	private BigDecimal couponsTotalAmount ;

}
