package com.zjxdqh.happchargeserver.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjxdqh.face.service.HappyCouponService;
import com.zjxdqh.face.vo.*;
import com.zjxdqh.happchargeserver.mapper.FCouponsConfigMapper;
import com.zjxdqh.happchargeserver.mapper.FCouponsMapper;
import com.zjxdqh.happchargeserver.mapper.FCouponsUserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 *
 * 优惠券操作类
 *
 * @author Yorking
 * @date 2019/09/12
 */
@RestController
@Log4j2
public class HappyCouponServiceImpl implements HappyCouponService {



    @Autowired
    private FCouponsMapper couponsMapper;
    @Autowired
    private FCouponsConfigMapper couponsConfigMapper;
    @Autowired
    private FCouponsUserMapper couponsUserMapper;

    /**
     * 查询 用户优惠券
     * @param uid
     * @param stat
     * @return
     */
    @Override
    public List<CouponsUserVo> getUserCoupons(Integer uid, Integer stat) {
        if (uid == null) {
            return null;
        }
        couponsUserMapper.updateCouponUserTimeout();
        Map<String, Object> param = new HashMap<>();
        param.put("userId", uid);
        if (stat != null) {
            param.put("couponsUserStat", stat);
        }
        return convertCouponUserVo(couponsUserMapper.getList(param));
    }


    /**
     * 查询 用户优惠券
     * @param uid
     * @param stat
     * @return
     */
    @Override
    public PageInfo<CouponsUserVo> getUserCouponsPage(Integer uid, Integer stat, int pageNo, int pageSize) {
        if (uid == null) {
            return null;
        }
        Map<String, Object> param = new HashMap<>();
        param.put("userId", uid);
        param.put("couponsUserStat", stat);
        PageInfo<FCouponsUser> pageInfo = PageHelper.startPage(pageNo, pageSize, true, false)
                .doSelectPageInfo(() -> couponsUserMapper.getList(param));
        List<FCouponsUser> list = pageInfo.getList();
        pageInfo.setList(null);
        PageInfo<CouponsUserVo> result = new PageInfo<>();
        BeanUtils.copyProperties(list, result);
        result.setList(convertCouponUserVo(list));
        return result;
    }

    private List<CouponsUserVo> convertCouponUserVo(List<FCouponsUser> coupons) {
        List<CouponsUserVo> couponsVos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(coupons)) {
            for (Object coupon : coupons) {
                CouponsUserVo vo = new CouponsUserVo();
                BeanUtils.copyProperties(coupon,vo);
                // 设置优惠券 相关配置
                vo.setCouponInfo(getCouponInfo(vo.getCouponsId()));
                couponsVos.add(vo);
            }
        }

        return couponsVos;
    }

    /**
     * 返回用户优惠券 信息
     * @param couponsUserId
     * @return
     */
    @Override
    public CouponsUserVo getUserCoupons(Integer couponsUserId) {
        FCouponsUser couponsUser = couponsUserMapper.getOne(Collections.singletonMap("couponsUserId", couponsUserId));
        if (couponsUser == null) {
            return null;
        }
        CouponsUserVo vo = new CouponsUserVo();
        BeanUtils.copyProperties(couponsUser,vo);
        // 设置优惠券 相关配置
        vo.setCouponInfo(getCouponInfo(vo.getCouponsId()));
        return vo;

    }


    /**
     * 查询 优惠券及使用配置条件
     * @param couponId
     * @return
     */
    public CouponInfoVo getCouponInfo(Integer couponId) {
        FCoupons coupons = couponsMapper.getOne(Collections.singletonMap("id", couponId));
        if (coupons == null) {
            return null;
        }
//        CouponInfoVo couponInfoVo = (CouponInfoVo) coupons;
        CouponInfoVo couponInfoVo = new CouponInfoVo();
        BeanUtils.copyProperties(coupons, couponInfoVo);
        couponInfoVo.setConfigs(getConfigs(couponInfoVo.getId()));

        return couponInfoVo;
    }

    private List<FCouponsConfig> getConfigs(Integer couponId) {
        return couponsConfigMapper.getList(Collections.singletonMap("couponId", couponId));
    }


    public boolean updateCouponUserTimeout() {
        return couponsUserMapper.updateCouponUserTimeout();
    }

}
