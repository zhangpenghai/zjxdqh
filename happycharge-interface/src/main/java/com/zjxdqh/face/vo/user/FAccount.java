package com.zjxdqh.face.vo.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 注意:注解只能加在属性字段上才会生效!
 *
 * @author code_generator
 */
@Table(name = "f_account")
@Data
public class FAccount implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**  **/
    @Id
    @Column(name = "aid")
    private Integer aid;

    /**  **/
    @Id
    @Column(name = "uid")
    private Integer uid;

    /**
     * 总余额= 余额 + 现金余额  （如 现金 + 账户余额  != 总余额 则说明账户异常）
     **/
    @Column(name = "balance")
    private BigDecimal balance;

    /**
     * 账户现金（理解用户现金充值的余额，总余额=积分+现金），用于拆分财务算账
     **/
    @Column(name = "cash")
    private BigDecimal cash;

    /**
     * 账户积分（理解成账户余额，总余额=积分+现金），用于拆分财务算账
     **/
    @Column(name = "amount")
    private BigDecimal amount;

    /**
     * -1 异常 0-停用 1-正常 （默认1）
     **/
    @Column(name = "status")
    private Integer status;

    /**  **/
    @Column(name = "createtime")
    private Date createtime;

    /**  **/
    @Column(name = "lasttime")
    private Date lasttime;

    /**
     * 不可退金额
     *
     */
    @Column(name = "noRefundAmount")
    private BigDecimal noRefundAmount;


}
