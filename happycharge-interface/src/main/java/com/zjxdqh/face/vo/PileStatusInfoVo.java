package com.zjxdqh.face.vo;

import lombok.Data;

/**
 *
 * 充电设备接口状态
 * @author chenshunhua
 * @date 2019/05/10
 */

@Data
public class PileStatusInfoVo {

    /**
     *桩号
     *
     */
    private String pilenum;

    /**
     *
     * 枪号
     */
    private String gnum;
    /**
     *
     * 枪号
     */
    private Integer gid;

    /**
     *充电设备接口状态
     *
     *
     -2-离线
     -1-故障
     0-空闲
     4-充电中
     1-使用中 占用（未充电 ）
     *
     *
     */
    private Integer gstate;


}
