package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.BChargeEndInfo;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: loiuhong
 * @date: 2020/4/21
 * @description: 充电结束采集信息映射
 */
@Repository
public interface BChargeEndInfoMapper extends IBaseMapper<BChargeEndInfo> {
    BChargeEndInfo findOne(@Param("orderNo") String orderNo);
}
