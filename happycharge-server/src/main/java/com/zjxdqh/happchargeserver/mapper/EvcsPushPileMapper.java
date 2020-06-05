package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.EvcsPushPile;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;

import java.util.List;

/**
 * @author: liuhong
 * @date: 2020/5/9
 * @description: 需要定时推送状态的所有桩的桩号
 */
public interface EvcsPushPileMapper  extends IBaseMapper<EvcsPushPile> {
    public List<EvcsPushPile> getEvcsPushPile();
}
