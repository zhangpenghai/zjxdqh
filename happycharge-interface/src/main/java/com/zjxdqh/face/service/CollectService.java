package com.zjxdqh.face.service;

import com.zjxdqh.face.config.HappyFeignConfig;
import com.zjxdqh.face.param.QueryPileGunStateParam;
import com.zjxdqh.face.vo.PileGunStateVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 *  读取采集数据库
 * @author chenshunhua
 * @date 2019/09/17
 */
@FeignClient(name = "collectService", url = "${feign.happy.url}", configuration = HappyFeignConfig.class)
public interface CollectService {


    /**
     *
     * 查询充电桩充电枪状态
     *
     */
    @PostMapping("queryPileGunState")
    @ResponseBody
    List<PileGunStateVo> queryPileGunState(@RequestBody QueryPileGunStateParam param);


}
