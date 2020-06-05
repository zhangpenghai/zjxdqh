package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.FOrder;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author: wangqinmin
 * @date: 2019/5/10 16:00
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
public interface ForderMapper extends IBaseMapper<FOrder> {
    /**
     * 获取：充电订单状态、开始充电时间、启动方式、本次采样时间
     *
     * @param param
     * @return
     */
    FOrder getForderBaseData(Map<String, Object> param);

    /**
     * 根据订单号
     *
     * @param orderNo
     * @return
     */
    FOrder getStopChargeResult(String orderNo);

    /**
     * 获取个人用户冻结金额
     *
     * @param uid
     * @return
     */
    BigDecimal getAloneFrozenBalance(@Param("uid") Integer uid);

    /**
     * 获取该企业子账户冻结金额
     *
     * @param uid
     * @return
     */
    BigDecimal getEnterpriseFrozenBalance(@Param("uid") Integer uid);

    /**
     * 查询该用户“不包含”多个状态的订单详情
     *
     * @param uid
     * @param ostate
     * @return
     */
    List<FOrder> queryAllComingOrders(@Param("uid") Integer uid, @Param("ostate") List<Integer> ostate);


    /**
     * 根据订单号
     *
     * @param orderNo
     * @return
     */
    FOrder queryLastOrder(@Param("pid") String pid, @Param("gunnumber") String gunnumber);

    /**
     * 根据订单号查询订单信息
     * @param oderSn
     * @return
     */
    FOrder findFOderBySn(@Param("oderSn") String oderSn);

    /**
     * 根据第三方订单信息查询订单信息
     * @param superviseSn
     * @return
     */
    FOrder findFOderBysuperviseSn(String superviseSn);
}