package com.zjxdqh.face.service;

import com.zjxdqh.face.config.HappyFeignConfig;
import com.zjxdqh.face.vo.PileSite;
import com.zjxdqh.face.vo.TestVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yorking
 * @date 2019/05/06
 */
@FeignClient(name = "testService", url = "${feign.happy.url}", configuration = HappyFeignConfig.class)
public interface TestService {

    /**
     * 测试接口
     * @return
     */
    @GetMapping("getTest")
    @ResponseBody
    TestVo getTest();



}
