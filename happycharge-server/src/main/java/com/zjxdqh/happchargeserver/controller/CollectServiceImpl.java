package com.zjxdqh.happchargeserver.controller;

import com.zjxdqh.face.enums.DataSource;
import com.zjxdqh.face.enums.DataSourceEnum;
import com.zjxdqh.face.param.QueryPileGunStateParam;
import com.zjxdqh.face.service.CollectService;
import com.zjxdqh.face.vo.PileGunStateVo;
import com.zjxdqh.happchargeserver.mapper.FPileGunMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenshunhua
 * @date 2019/09/17
 */
@RestController
@Log4j2
public class CollectServiceImpl implements CollectService{

    @Autowired
    private FPileGunMapper fPileGunMapper;

    @Override
    @DataSource(DataSourceEnum.COLLECT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<PileGunStateVo> queryPileGunState(QueryPileGunStateParam param) {
        return fPileGunMapper.queryPileGunState(param.getPilenum(),param.getGnum());
    }
}
