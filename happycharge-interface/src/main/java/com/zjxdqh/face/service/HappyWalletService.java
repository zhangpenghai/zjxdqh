package com.zjxdqh.face.service;

import com.github.pagehelper.PageInfo;
import com.zjxdqh.face.config.HappyFeignConfig;
import com.zjxdqh.face.param.ApplicationRefundParam;
import com.zjxdqh.face.param.QueryRefundParam;
import com.zjxdqh.face.param.QueryRefundRecordParam;
import com.zjxdqh.face.param.RechargeOrderParam;
import com.zjxdqh.face.vo.*;
import com.zjxdqh.face.vo.user.FAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yorking
 * @date 2019/05/09
 */
@FeignClient(name = "happyWalletService", url = "${feign.happy.url}", configuration = HappyFeignConfig.class)
public interface HappyWalletService {


    @PostMapping("getRechargeRecord")
    @ResponseBody
    PageInfo<RechargeRecordVo> getRechargeRecord(@RequestBody RechargeOrderParam param);

    @GetMapping("getFaccount")
    @ResponseBody
    FAccount getFaccount(@RequestParam("uid") Integer uid);


    /**
     * 获取用户账单信息
     *
     * @param date    按月查询时间  "2019-09"
     * @param page    页数
     * @param typeOne 个人账户查询，typeOne不为空
     * @param typeTwo 企业账户查询，typeTwo不为空
     * @return
     */
    @GetMapping("getUserBill")
    @ResponseBody
    PageInfo<UserBillVo> getUserBill(@RequestParam("uid") Integer uid, @RequestParam("date") String date, @RequestParam("page") Integer page, @RequestParam(value="typeOne",required = false) Integer typeOne, @RequestParam(value= "typeTwo",required = false) Integer typeTwo);

    /**
     * 获取用户账单 查询总消费、总充值
     *
     * @param date    按月查询时间  "2019-09"
     * @param page    页数
     * @param typeOne 个人账户查询，typeOne不为空
     * @param typeTwo 企业账户查询，typeTwo不为空
     * @return
     */
    @GetMapping("getUserBillTotal")
    @ResponseBody
    UserBillTotalVo getUserBillTotal(@RequestParam("uid") Integer uid, @RequestParam("date") String date, @RequestParam("page") Integer page, @RequestParam(value="typeOne",required = false) Integer typeOne, @RequestParam(value= "typeTwo",required = false) Integer typeTwo);

    /**
     * 申请退款首页
     *
     * @param param
     * @return
     */
    @PostMapping("queryRefund")
    @ResponseBody
    QueryRefundVo queryRefund(@RequestBody QueryRefundParam param);

    /**
     * 确认申请退款
     *
     * @param param
     * @return
     */
    @PostMapping("applicationRefund")
    @ResponseBody
    boolean applicationRefund(@RequestBody ApplicationRefundParam param);


    /**
     * 查询退款记录接口
     */
    @PostMapping("queryRefundRecord")
    @ResponseBody
    PageInfo<RefundRecordVo> queryRefundRecord(@RequestBody QueryRefundRecordParam param);

}
