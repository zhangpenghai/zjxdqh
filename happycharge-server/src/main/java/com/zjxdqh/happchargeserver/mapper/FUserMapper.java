package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import com.zjxdqh.happchargeserver.model.FUser;
import org.apache.ibatis.annotations.Param;

/**
 * mapper接口,自定义方法写入此接口,并在xml中实现
 *
 * @author code_generator
 */
public interface FUserMapper extends IBaseMapper<FUser> {


    /**
     * 根据手机号修改密码
     *
     * @param password
     * @param phone
     * @return
     */
    Integer updateLoginPassword(@Param("pwd") String password, @Param("phone") String phone);

    /**
     * FUser getFUserByPhone(String phone);
     *
     * @param phone
     * @return
     */
    FUser getFUserByPhone(String phone);
}
