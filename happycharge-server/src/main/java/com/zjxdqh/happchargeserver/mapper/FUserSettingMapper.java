package com.zjxdqh.happchargeserver.mapper;


import com.zjxdqh.face.vo.FUserSetting;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * mapper接口,自定义方法写入此接口,并在xml中实现
 *
 * @author code_generator
 */
public interface FUserSettingMapper extends IBaseMapper<FUserSetting> {


    FUserSetting getFuserSettingByUid(@Param("uid") Integer uid);

    Integer insertFUserSetting(FUserSetting fUserSetting);

    Integer updateFuserSetting(@Param("fUserSetting") FUserSetting fUserSetting);
}
