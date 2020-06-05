package com.zjxdqh.face.param;

import lombok.Data;

/**
 * 设备状态变化推送接口参数
 * @author chenshunhua
 * @date 2019/5/10
 */
@Data
public class DeviceStatusParam {


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
