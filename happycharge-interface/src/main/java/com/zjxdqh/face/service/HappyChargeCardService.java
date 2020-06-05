package com.zjxdqh.face.service;

import com.zjxdqh.face.config.HappyFeignConfig;
import com.zjxdqh.face.vo.CouponsUserVo;
import com.zjxdqh.face.vo.FCouponsUser;
import com.zjxdqh.face.vo.FPileChargCardVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: wangqinmin
 * @date: 2019/9/19 15:30
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
@FeignClient(name = "happyChargeCardService", url = "${feign.happy.url}", configuration = HappyFeignConfig.class)
public interface HappyChargeCardService {

    /**
     * 账号卡详情查询
     *
     * @param pcstate    -1挂失 0-停用 1-正常
     * @param usertype   0-个人用户 1-企业用户
     * @param uid
     * @param activation 1-绑定 0-未绑定
     * @return
     * @RequestParam("usertype") Integer usertype
     */
    @PostMapping("/getChargeCards")
    @ResponseBody
    List<FPileChargCardVo> getChargeCards(@RequestParam("pcstate") Integer pcstate , @RequestParam("uid") Integer uid, @RequestParam(name = "activation") Integer activation);
}
