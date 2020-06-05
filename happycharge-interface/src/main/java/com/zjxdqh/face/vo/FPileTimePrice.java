package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 注意:注解只能加在属性字段上才会生效!
 *
 * @author code_generator
 */
@Data
@Table(name = "f_pile_time_price")
public class FPileTimePrice implements Serializable {
    private static final long serialVersionUID = 1L;

    /**  **/
    @Id
    @Column(name = "ptid")
    private Integer ptid;

    /**
     * 标识码
     **/
    @Column(name = "sid")
    private Long sid;

    /**  **/
    @Column(name = "stime")
    private String stime;

    /**  **/
    @Column(name = "etime")
    private String etime;

    /**  **/
    @Column(name = "price")
    private BigDecimal price;

    /**  **/
    @Column(name = "createtime")
    private Date createtime;

    /**  **/
    @Column(name = "pricetype")
    private Integer pricetype;

    /**  **/
    @Column(name = "serviceprice")
    private Double serviceprice;
}
