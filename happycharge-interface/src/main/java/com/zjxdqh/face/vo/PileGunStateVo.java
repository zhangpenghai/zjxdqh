package com.zjxdqh.face.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 充电桩充电枪状态
 * @author chenshunhua
 * @date 2019/09/17
 */
@Data
public class PileGunStateVo implements Serializable {

    private String pileNum;
    private String gunNum;
    /**
     * 通讯状态 通信状态 1-在线，2-离线
     */
    private String pileSigninState;
    /**
     * 桩状态 1-正常 2-故障 3-停用 4-审核中
     */
    private String buildStatus;
    /**
     * 充电状态：1-空闲，2-充电枪已连接，3-启动中，4-充电中，5-充电完成，6-已预约，7等待充电预约已插枪
     */
    private String gunChargingState;

}
