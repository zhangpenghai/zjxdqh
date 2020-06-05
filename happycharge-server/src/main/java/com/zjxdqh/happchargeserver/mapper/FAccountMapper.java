package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.param.RefundAmountParam;
import com.zjxdqh.face.vo.QueryRefundVo;
import com.zjxdqh.face.vo.user.FAccount;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * mapper接口,自定义方法写入此接口,并在xml中实现
 *
 * @author code_generator
 */
public interface FAccountMapper extends IBaseMapper<FAccount> {


    /**
     * 申请退款首页
     *
     * @return
     */
    QueryRefundVo queryRefund(@Param("uid") Integer uid);

    /**
     * 退款金额
     *
     * @return
     */
    boolean updateAmountById(@Param("param")RefundAmountParam param);



}
