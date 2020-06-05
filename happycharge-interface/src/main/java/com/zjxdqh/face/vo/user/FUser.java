package com.zjxdqh.face.vo.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 注意:注解只能加在属性字段上才会生效!
 *
 * @author code_generator
 */
@Table(name = "f_user")
@Data
public class FUser implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**  **/
    @Id
    @Column(name = "uid")
    private Integer uid;

    /**  **/
    @Column(name = "uname")
    private String uname;

    /**  **/
    @Id
    private String phone;

    /**  **/
    @Column(name = "pwd")
    private String pwd;

    /**  **/
    @Column(name = "salt")
    private String salt;

    /**  **/
    @Column(name = "paypwd")
    private String paypwd;

    /**  **/
    @Column(name = "paysalt")
    private String paysalt;

    /**  **/
    @Column(name = "nickname")
    private String nickname;

    /**  **/
    @Column(name = "nickicon")
    private String nickicon;

    /**  **/
    @Column(name = "lid")
    private Integer lid;

    /**  **/
    @Column(name = "lastIP")
    private String lastip;

    /**  **/
    @Column(name = "nowIP")
    private String nowip;

    /**  **/
    @Column(name = "lasttime")
    private Date lasttime;

    /**  **/
    @Column(name = "nowtime")
    private Date nowtime;

    /**  **/
    @Column(name = "regIP")
    private String regip;

    /**  **/
    @Column(name = "regtime")
    private Date regtime;

    /**
     * 企业账户的id
     **/
    @Column(name = "cid")
    private Integer cid;

    /**
     * 用户总积分
     **/
    @Column(name = "score")
    private Integer score;

    /**
     * 1使用  2禁止   0未使用、删除 (默认为0)
     **/
    @Column(name = "iscompany")
    private Integer iscompany;

    /**  **/
    @Column(name = "sex")
    private Integer sex;

    /**  **/
    @Column(name = "birsday")
    private String birsday;

    /**  **/
    @Column(name = "provinceid")
    private String provinceid;

    /**  **/
    @Column(name = "cityid")
    private String cityid;

    /**  **/
    @Column(name = "countyid")
    private String countyid;

    /**  **/
    @Column(name = "address")
    private String address;

    /**
     * 基础信息填写完整后，是否给出积分
     **/
    @Column(name = "baseinformation")
    private Integer baseinformation;

    /**
     * 身份证上传成功后，是否给出积分
     **/
    @Column(name = "realnameauth")
    private Integer realnameauth;

    /**
     * 身份证号码
     **/
    @Column(name = "identitycard")
    private String identitycard;

    /**
     * 用户登录次数
     **/
    @Column(name = "countNum")
    private Integer countnum;

    /**
     * 用户状态  1再用状态- 2删除状态
     **/
    @Column(name = "userStatus")
    private Integer userstatus;

    /**
     * 会员图标是否改变 1未改变  2改变(默认为2)
     **/
    @Column(name = "typeicon")
    private Integer typeicon;


}
