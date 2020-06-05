package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;

/**
 * @author: wangqinmin
 * @date: 2019/5/13 10:46
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
public interface ForderSettlementMapper extends IBaseMapper<com.zjxdqh.face.vo.FOrderSettlement> {

    /**
     * 充电状态接口：充电成功后，返回部分数据
     *
     * @param sn
     * @return
     */
    com.zjxdqh.happchargeserver.model.ForderSettlement getChargeSuccessState(String sn);

}
