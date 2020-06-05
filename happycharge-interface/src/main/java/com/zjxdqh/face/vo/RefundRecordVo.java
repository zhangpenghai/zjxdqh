package com.zjxdqh.face.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * 退款记录
 *
 */
@Data
@Table(name = "f_refund_record")
public class RefundRecordVo implements java.io.Serializable{


    /**
     * 申请时间
     */
    @Column(name="createtime")
    private Date createtime;

    /**
     *
     * 退款状态
     *
     */
    @Column(name="status")
    private String status;

    /**
     *
     * 退款金额
     *
     */
    @Column(name="refundAmount")
    private String refundAmount;
    /**
     *
     * 退款失败原因
     *
     */
    @Column(name="refundFailReason")
    private String refundFailReason="";

    /**
     *
     * 退款成功时间
     *
     */
    @Column(name="successtime")
    private Date successtime;
    /**
     *
     * 退款失败时间
     *
     */
    @Column(name="failtime")
    private  Date failtime;





}
