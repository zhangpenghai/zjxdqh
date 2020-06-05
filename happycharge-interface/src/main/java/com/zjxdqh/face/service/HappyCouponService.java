package com.zjxdqh.face.service;

import com.github.pagehelper.PageInfo;
import com.zjxdqh.face.config.HappyFeignConfig;
import com.zjxdqh.face.vo.CouponsUserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Yorking
 * @date 2019/05/09
 */
@FeignClient(name = "happyCouponService", url = "${feign.happy.url}", configuration = HappyFeignConfig.class)
public interface HappyCouponService {

    /**
     * 查询 用户优惠券 列表
     *
     * @param uid
     * @param stat
     * @return
     */
    @PostMapping("/getUserCoupons")
    @ResponseBody
    List<CouponsUserVo> getUserCoupons(@RequestParam("uid") Integer uid, @RequestParam(name = "stat",required = false) Integer stat);

    /**
     * 分页 查询 优惠券
     * @param uid
     * @param stat
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/getUserCouponsPage")
    @ResponseBody
    PageInfo<CouponsUserVo> getUserCouponsPage(@RequestParam("uid") Integer uid, @RequestParam(name = "stat",required = false) Integer stat,
                                               @RequestParam(name = "pageNo",required = false, defaultValue = "1") int pageNo,
                                               @RequestParam(name = "pageSize",required = false, defaultValue = "10") int pageSize);

    /**
     * 查询 用户优惠券 详情
     *
     * @param couponsUserId  用户优惠券ID
     * @return
     */
    @PostMapping("/getUserCouponsById")
    @ResponseBody
    CouponsUserVo getUserCoupons(@RequestParam("couponsUserId") Integer couponsUserId);


}
