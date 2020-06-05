package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.FUserAppLogin;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * mapper接口,自定义方法写入此接口,并在xml中实现
 *
 * @author code_generator
 */
public interface FUserAppLoginMapper extends IBaseMapper<FUserAppLogin> {

    Integer updateFUserAppLogin(@Param("token") String token, @Param("uid") Integer uid);
}
