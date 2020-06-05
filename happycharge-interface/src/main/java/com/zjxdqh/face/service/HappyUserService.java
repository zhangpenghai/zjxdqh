package com.zjxdqh.face.service;

import com.zjxdqh.face.config.HappyFeignConfig;
import com.zjxdqh.face.vo.FUserSetting;
import com.zjxdqh.face.vo.user.FUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yorking
 * @date 2019/05/09
 */
@FeignClient(name = "happyUserService", url = "${feign.happy.url}", configuration = HappyFeignConfig.class)
public interface HappyUserService {
    /**
     * 根据ID查询用户信息
     * @param userid
     * @return
     */
    @GetMapping("getUserById")
    @ResponseBody
    FUser getUserById(@RequestParam("userid") Integer userid);

    @GetMapping("getUser")
    @ResponseBody
    FUser getUser(@RequestParam("phone") String phone);

    @PostMapping("setFuserSetting")
    @ResponseBody
    Integer setFuserSetting(@RequestBody FUserSetting fUserSetting);

    @GetMapping("updateLoginPassword")
    @ResponseBody
    Integer updateLoginPassword(@RequestParam("password") String password, @RequestParam("phone") String phone);

    @GetMapping("getFUserSetting")
    @ResponseBody
    FUserSetting getFUserSetting(@RequestParam("uid") Integer uid);

    @GetMapping("updateFUserAppLogin")
    @ResponseBody
    Integer updateFUserAppLogin(@RequestParam("token") String token, @RequestParam("uid") Integer uid);


}
