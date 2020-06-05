package com.zjxdqh.happchargeserver.mapper;

import java.util.List;
import java.util.Map;

import com.zjxdqh.face.param.RechargeOrderParam;
import com.zjxdqh.face.vo.RechargeRecordVo;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import com.zjxdqh.face.vo.FOrderRecharge;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * mapper接口,自定义方法写入此接口,并在xml中实现
 * @author code_generator
 */
@Repository
public interface FOrderRechargeMapper extends IBaseMapper<FOrderRecharge> {


    List<RechargeRecordVo>  getPageList(@Param("param")RechargeOrderParam param);



}
