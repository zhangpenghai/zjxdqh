package com.zjxdqh.face.vo;

import lombok.Data;

import java.util.List;

/**
 * 优惠券及配置信息
 * @author Yorking
 * @date 2019/09/12
 */
@Data
public class CouponInfoVo extends FCoupons {

    private List<FCouponsConfig> configs;
}
