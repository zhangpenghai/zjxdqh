package com.zjxdqh.face.service;

import com.zjxdqh.face.config.HappyFeignConfig;
import com.zjxdqh.face.param.PayOrderParam;
import com.zjxdqh.face.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Yorking
 * @date 2019/05/09
 */
@FeignClient(name = "happyOrderService", url = "${feign.happy.url}", configuration = HappyFeignConfig.class)
public interface HappyOrderService {

    @GetMapping("getFrozenAccount")
    @ResponseBody
    FrozenAccountVo getFrozenAccount(@RequestParam("uid") Integer uid);

    @GetMapping("queryAllComingOrders")
    @ResponseBody
    List<FOrder> queryAllComingOrders(@RequestParam("uid") Integer uid, @RequestParam("ostate") List<Integer> ostate);

    @GetMapping("queryChargingDetails")
    @ResponseBody
    FOrder queryChargingDetails(@RequestParam("sn") String sn);

    @GetMapping("queryLastOrder")
    @ResponseBody
    FOrder queryLastOrder(@RequestParam("pileNum") String pileNum, @RequestParam("gunNum") String gunNum);

    @GetMapping("queryFPile")
    @ResponseBody
    FPile queryFPile(@RequestParam("pilenum") String pilenum);

    @GetMapping("queryFpileSite")
    @ResponseBody
    FPileSite queryFpileSite(@RequestParam("sid") String sid);


    @GetMapping("getListPileGun")
    @ResponseBody
    List<PileStatusInfoVo> getListPileGun(@RequestParam("pilenum") String pilenum, @RequestParam("gnum") String gnum);

    @GetMapping("selectTime")
    @ResponseBody
    FPileTimePrice selectTime(@RequestParam("ptid") String ptid);


    @GetMapping("getForderSettlement")
    @ResponseBody
    FOrderSettlement getForderSettlement(@RequestParam("sn") String sn);

    @GetMapping("getOrderStarttime")
    @ResponseBody
    String getOrderStarttime(@RequestParam("uid") Integer uid);

    @PostMapping("payOrder")
    @ResponseBody
    boolean payOrder(@RequestBody PayOrderParam param);
}
