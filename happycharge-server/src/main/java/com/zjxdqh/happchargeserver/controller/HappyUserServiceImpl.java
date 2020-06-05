package com.zjxdqh.happchargeserver.controller;

import com.zjxdqh.face.common.UUIDUtil;
import com.zjxdqh.face.exception.BuzzException;
import com.zjxdqh.face.service.HappyUserService;
import com.zjxdqh.face.vo.FUserSetting;
import com.zjxdqh.face.vo.user.FUser;
import com.zjxdqh.happchargeserver.mapper.FUserAppLoginMapper;
import com.zjxdqh.happchargeserver.mapper.FUserMapper;
import com.zjxdqh.happchargeserver.mapper.FUserSettingMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yorking
 * @date 2019/05/09
 */
@RestController
@Log4j2
public class HappyUserServiceImpl implements HappyUserService {

    @Autowired
    FUserMapper userMapper;

    @Autowired
    FUserSettingMapper fUserSettingMapper;

    @Autowired
    FUserAppLoginMapper fUserAppLoginMapper;

    /**
     * 根据ID查询用户信息
     * @param userid
     * @return
     */
    @Override
    public FUser getUserById(Integer userid) {
        Map<String, Object> param = new HashMap<>();
        param.put("uid", userid);
        return userMapper.getOne(param);
    }

    @Override
    public FUser getUser(String phone) {
        return userMapper.getOne(Collections.singletonMap("phone", phone));
    }



    /**
     * 新增/更新--用户配置表
     * 1. 当用户uid存在时,更新用户配置表
     * 2. 当用户uid不存在是，新增数据
     *
     * @param fUserSetting
     * @return
     */
    @Override
    public Integer setFuserSetting(FUserSetting fUserSetting) {
        /**
         * 根据用户uid查询用户配置信息
         */
        FUserSetting fUserSetIsExists = fUserSettingMapper.getFuserSettingByUid(fUserSetting.getUid());
        if (ObjectUtils.isEmpty(fUserSetIsExists)) {
            fUserSetting.setId(UUIDUtil.getUUID());
            /**
             * 新增用户配置信息
             */
            return fUserSettingMapper.insertFUserSetting(fUserSetting);
        }
        /**
         * 修改用户配置信息（必须传入数据）
         */
        return fUserSettingMapper.updateFuserSetting(fUserSetting);
    }

    /**
     * 根据手机号，修改密码
     *
     * @param password
     * @param phone
     * @return
     */
    @Override
    public Integer updateLoginPassword(String password, String phone) {
        return userMapper.updateLoginPassword(password, phone);
    }

    @Override
    public FUserSetting getFUserSetting(Integer uid) {
        return fUserSettingMapper.getFuserSettingByUid(uid);
    }

    /**
     * 更新token
     *
     * @param token
     * @param uid
     */
    @Override
    public Integer updateFUserAppLogin(String token, Integer uid) {
        Integer count = fUserAppLoginMapper.updateFUserAppLogin(token, uid);
        if (count != 1) {
            throw new BuzzException("用户token表更新失败");
        }
        return count;
    }


}
