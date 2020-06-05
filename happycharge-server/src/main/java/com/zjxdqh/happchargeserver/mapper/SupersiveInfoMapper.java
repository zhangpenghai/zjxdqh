package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.SupersiveInfo;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper接口,自定义方法写入此接口,并在xml中实现
 *
 * @author code_generator
 */
@Repository
public interface SupersiveInfoMapper extends IBaseMapper<SupersiveInfo> {

    List<SupersiveInfo> getSupersiveInfoByPilenum(@Param("pileNum") String pileNum);

    List<SupersiveInfo> getSupersiveInfoBySid(@Param("sid") String dis);

}
