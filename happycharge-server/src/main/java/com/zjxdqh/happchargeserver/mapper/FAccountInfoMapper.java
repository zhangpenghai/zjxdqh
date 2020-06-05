package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.UserBillTotalVo;
import com.zjxdqh.face.vo.UserBillVo;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import com.zjxdqh.happchargeserver.model.FAccountInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * mapper接口,自定义方法写入此接口,并在xml中实现
 *
 * @author code_generator
 */
public interface FAccountInfoMapper extends IBaseMapper<FAccountInfo> {


    /**
     * 查询第一条流水创建时间  格式: "2019-08"
     *
     * @param uid
     * @return
     */
    String getOrderStarttime(@Param("uid") Integer uid);


    /**
     * 获取用户账单信息
     *
     * @param date    按月查询时间  "2019-09"
     * @param page    页数
     * @param typeOne 个人账户查询，typeOne不为空
     * @param typeTwo 企业账户查询，typeTwo不为空
     * @return
     */
    List<UserBillVo> getUserBill(@Param("uid") Integer uid, @Param("date") String date, @Param("page") Integer page, @Param("typeOne") Integer typeOne, @Param("typeTwo") Integer typeTwo);

    /**
     * 总充值
     *
     * @param uid
     * @param date
     * @param typeOne
     * @param typeTwo
     * @return
     */
    BigDecimal getTotalRecharge(@Param("uid") Integer uid, @Param("date") String date, @Param("typeOne") Integer typeOne, @Param("typeTwo") Integer typeTwo);

    /**
     * 总消费
     *
     * @param uid
     * @param date
     * @param typeOne
     * @param typeTwo
     * @return
     */
    BigDecimal getTotalConsume(@Param("uid") Integer uid, @Param("date") String date, @Param("typeOne") Integer typeOne, @Param("typeTwo") Integer typeTwo);
}
