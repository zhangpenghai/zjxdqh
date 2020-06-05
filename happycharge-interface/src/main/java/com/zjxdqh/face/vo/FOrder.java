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
 * 充电订单
 *
 * @author code_generator
 */
@Data
@Table(name = "f_order")
public class FOrder implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**  **/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer oid;

    /**
     * 订单号
     **/
    @Column(name = "sn")
    private String sn;

    /**
     * 1-充电订单 2-预约订单
     **/
    @Column(name = "otype")
    private Integer otype;

    /**
     * 准备中（2），启动中( 3 )，充电中（0），结算中( 4 )，已完成（1）, 已失效（-1）
     **/
    @Column(name = "ostate")
    private Integer ostate;

    /**
     * 1正常，2异常
     **/
    @Column(name = "setle_status")
    private Integer setleStatus;

    /**
     * 用户uid
     **/
    @Column(name = "uid")
    private Integer uid;

    /**
     * 预付费
     **/
    @Column(name = "amount")
    private BigDecimal amount;

    /**  **/
    @Column(name = "couponbalance")
    private BigDecimal couponbalance;

    /**  **/
    @Column(name = "realbalance")
    private BigDecimal realbalance;

    /**
     * 如有使用优惠券该大于0 或者不为null
     **/
    @Column(name = "cid")
    private Integer cid;

    /**
     * 桩编号
     **/
    @Column(name = "pid")
    private String pid;

    /**
     * 枪号
     **/
    @Column(name = "gunnumber")
    private String gunnumber;

    /**
     * 枪编号
     **/
    @Column(name = "gid")
    private Integer gid;

    /**
     * 订单开始时间
     **/
    @Column(name = "starttime")
    private Date starttime;

    /**
     * 订单结束时间
     **/
    @Column(name = "endtime")
    private Date endtime;

    /**
     * 车辆开始充电时电量
     **/
    @Column(name = "bsoc")
    private Integer bsoc;

    /**
     * 车辆结束充电时电量
     **/
    @Column(name = "esoc")
    private Integer esoc;

    /**
     * 使用电量
     **/
    @Column(name = "useele")
    private Double useele;

    /**
     * 电价
     **/
    @Column(name = "ele_price")
    private BigDecimal elePrice;

    /**
     * -8.桩缓存通道获取错误,-7.桩号错误,-6.枪号错误,-5.余额不足,-4.账户卡未绑定,-3.枪故障,-2.桩离线,-1.未插枪，0.无操作 1. 充满停止 2. 主动停⽌ 3. 枪连接断开停⽌4. 故障停止（详情息）。 5. 异常停⽌ 6. 余额不⾜停⽌ 7. 失电停⽌ 8.离线结算
     **/
    @Column(name = "end_reason")
    private Integer endReason;

    /**
     * 启动类型0，默认充满1，按电量充2，按⾦额充3，按时间充
     **/
    @Column(name = "use_type")
    private Integer useType;

    /**
     * 赠送积分
     **/
    @Column(name = "scro")
    private Integer scro;

    /**
     * 车牌
     **/
    @Column(name = "car_id")
    private String carId;

    /**
     * 车辆唯一码
     **/
    @Column(name = "car_vin")
    private String carVin;

    /**
     * 服务费
     **/
    @Column(name = "server_price")
    private BigDecimal serverPrice;

    /**
     * 创建时间
     **/
    @Column(name = "createtime")
    private Date createtime;

    /**
     * 预约产生一个订单，到达现场扫码支付也产生订单，该字段用于关联到之前的预约订单.
     **/
    @Column(name = "roid")
    private Integer roid;

    /**
     * 0-app余额支付 1-电卡支付 2企业账户
     **/
    @Column(name = "paytype")
    private Integer paytype;

    /**
     * 预约时间（预约订单用）
     **/
    @Column(name = "order_time")
    private String orderTime;

    /**  **/
    @Column(name = "is_push")
    private Integer isPush;

    /**  **/
    @Column(name = "is_comment")
    private Integer isComment;

    /**
     * 预付费退款金额
     **/
    @Column(name = "back_money")
    private BigDecimal backMoney;

    /**  **/
    @Column(name = "card_sn")
    private String cardSn;

    /**
     * 企业标识
     **/
    @Column(name = "ecid")
    private Integer ecid;

    /**
     * 订单来源方
     **/
    @Column(name = "supervise_id")
    private Integer superviseId;

    /**
     * 来源订单号
     **/
    @Column(name = "supervise_sn")
    private String superviseSn;

    /**
     * 最近修改时间
     **/
    @Column(name = "update_time")
    private Date updateTime;
}
