package com.zjxdqh.face.param;

import lombok.Data;

/**
 * 查询充电桩，充电枪状态
 * @author chenshunhua
 * @date 2019/09/07
 */
@Data
public class QueryPileGunStateParam {

    /**
     *
     * 桩号
     *
     */
    private String pilenum;

    /**
     *
     * 枪号
     *
     */
    private String gnum;



}
