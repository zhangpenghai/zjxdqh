package com.zjxdqh.happchargeserver.controller;

import com.zjxdqh.face.vo.TestVo;
import com.zjxdqh.happchargeserver.mapper.FPileSiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yorking
 * @date 2019/05/05
 */
@RestController
public class TestService implements com.zjxdqh.face.service.TestService {

    @Autowired
    FPileSiteMapper fpileSiteMapper;


    @Override
    public TestVo getTest() {
        TestVo t = new TestVo();
        t.setId(12);
        t.setName("name...");
        return t;
    }

}
