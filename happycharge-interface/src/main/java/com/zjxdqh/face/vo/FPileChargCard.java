package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 充电卡列表
 *
 * @author code_generator
 */
@Data
@Table(name = "f_pile_charg_card")
public class FPileChargCard implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**  **/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer pcid;

    /**  **/
    @Column(name = "SN")
    private String sn;

    /**  **/
    @Column(name = "password")
    private String password;

    /**
     * -1挂失0-停用 1-正常
     **/
    @Column(name = "pcstate")
    private Integer pcstate;

    /**  **/
    @Column(name = "expiretime")
    private Date expiretime;

    /**  **/
    @Column(name = "createtime")
    private Date createtime;

    /**
     * 1-绑定 0-未绑定
     **/
    @Column(name = "activation")
    private Integer activation;

    /**  **/
    @Column(name = "uid")
    private Integer uid;

    /**  **/
    @Column(name = "banbale")
    private BigDecimal banbale;

    /**
     * 0-个人用户 1-企业用户
     **/
    @Column(name = "usertype")
    private Integer usertype;
}
