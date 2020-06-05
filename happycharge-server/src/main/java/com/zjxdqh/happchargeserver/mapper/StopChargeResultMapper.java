package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.happchargeserver.model.StopChargeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @outhor liusiyu
 * @create 2019-05-10-17:21
 */
@Repository
public interface StopChargeResultMapper {
    StopChargeVo orderByNum(@RequestParam("orderNo") String orderNo);
}
