package com.zjxdqh.happchargeserver.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * 注意:注解只能加在属性字段上才会生效!
 *
 * @author code_generator
 */
@Data
@Table(name = "f_pile_gun")
public class FPileGun implements Serializable {

    private static final long serialVersionUID = 1L;

    /**  **/
    @Id
    private Integer id;

    /**  **/
    @Column(name = "pid")
    private Integer pid;

    /**  **/
    @Column(name = "gname")
    private String gname;

    /**  **/
    @Column(name = "gnum")
    private String gnum;

    /**  **/
    @Column(name = "cnum")
    private String cnum;

    /**  **/
    @Column(name = "ghwnum")
    private String ghwnum;

    /**
     * -2-离线， -1-故障， 0-空闲 ，4-充电中 ，1-使用中 占用（未充电 ）
     **/
    @Column(name = "gstate")
    private Integer gstate;

    /**  **/
    @Column(name = "lasttime")
    private Date lasttime;

    /**  **/
    @Column(name = "createtime")
    private Date createtime;

    /**  **/
    @Column(name = "gid")
    private Integer gid;

    /**  **/
    @Column(name = "comunicate")
    private Integer comunicate;

    /**  **/
    @Column(name = "wpilenum")
    private String wpilenum;
}
