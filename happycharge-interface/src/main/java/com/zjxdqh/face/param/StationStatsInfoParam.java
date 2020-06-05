package com.zjxdqh.face.param;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 *  充电站统计信息 输入值
 * <p>
 *
 * @author PengWei
 * @date 2019/5/10
 */
@Data
public class StationStatsInfoParam {

    /**
     * 充电站 ID
     */
    private String StationID;

    /**
     * 统计开始时间
     */

    private Date StartTime;

    /**
     * 统计结束时间
     */
    private Date EndTime;
}
