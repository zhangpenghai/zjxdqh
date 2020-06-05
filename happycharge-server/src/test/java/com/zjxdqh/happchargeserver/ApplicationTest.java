package com.zjxdqh.happchargeserver;

import com.github.pagehelper.PageInfo;
import com.zjxdqh.face.service.HappyService;
import com.zjxdqh.face.vo.FOrder;
import com.zjxdqh.face.vo.FPile;
import com.zjxdqh.face.vo.FPileSite;
import com.zjxdqh.face.vo.FUserSetting;
import com.zjxdqh.happchargeserver.controller.HappyOrderServiceImpl;
import com.zjxdqh.happchargeserver.controller.HappyUserServiceImpl;
import com.zjxdqh.happchargeserver.mapper.FPileSiteMapper;
import com.zjxdqh.happchargeserver.mapper.FUserSettingMapper;
import com.zjxdqh.happchargeserver.mapper.ForderMapper;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @author Yorking
 * @date 2019/05/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HappyChargeServiceApplication.class)
@ActiveProfiles("dev")
public class ApplicationTest {

    @Autowired
    private HappyService happyService;

    @Autowired
    private ForderMapper forderMapper;

    @Autowired
    private FPileSiteMapper pileSiteMapper;

    @Autowired
    HappyUserServiceImpl happyUserServiceImpl;

    @Autowired
    HappyOrderServiceImpl happyOrderService;


    @Test
    public void testGetSupervisePile() {

        Date n = DateUtils.addYears(new Date(), -1);
        List<FPile> piles = pileSiteMapper.getSupervisePile(Collections.singletonList(79), n);
        System.out.println(piles.size());
        Assert.notEmpty(piles, "piles 不能为空");
    }

    @Test
    public void testGetSuperviseSite() {
        PageInfo<FPileSite> sites = happyService.getSuperviseSite(null, null, 1, 10);
        System.out.println(sites);
        Assert.notEmpty(sites.getList(), "sites 不能为空");
    }


    /**
     * Forder测试
     */
    @Test
    public void setFOrder() {
        Map<String, Object> map = new HashMap<>();
        map.put("oid", 139617);
//        List<FOrder> forderBaseData = forderMapper.getList(map);
        FOrder forderBaseData = forderMapper.getOne(map);
        System.out.println(forderBaseData);

    }

    /**
     * 指定订单状态 ，查询订单
     */
    @Test
    public void queryAllComingOrders() {
        List<Integer> ostate = new ArrayList<>();
        ostate.add(1);
        ostate.add(-1);
        List<FOrder> forderBaseData = forderMapper.queryAllComingOrders(1033, ostate);
        System.out.println(forderBaseData);

    }

    /**
     * 查询订单详情
     */
    @Test
    public void queryChargingDetails() {
        FOrder fOrder = happyOrderService.queryChargingDetails("T2019082116304066688800000001231");
        System.out.println(fOrder);

    }

}
