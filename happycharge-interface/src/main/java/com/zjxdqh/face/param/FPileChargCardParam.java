package com.zjxdqh.face.param;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 注意:注解只能加在属性字段上才会生效!
 * 充电卡列表
 *
 * @author code_generator
 */
@Data
public class FPileChargCardParam implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**  **/
    private Integer pcid;

    /** 账号卡 **/
    private String sn;

    /**  **/
    private String password;

    /**
     * -1挂失0-停用 1-正常
     **/
    private Integer pcstate;

    /**  **/
    private Date expiretime;

    /**  **/
    private Date createtime;

    /**
     * 1-绑定 0-未绑定
     **/
    private Integer activation;

    /** 用户id **/
    private Integer uid;

    /**  **/
    private BigDecimal banbale;

    /**
     * 0-个人用户 1-企业用户
     **/
    private Integer usertype;
}
