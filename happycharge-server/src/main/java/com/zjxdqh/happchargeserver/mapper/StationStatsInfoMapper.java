package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.param.StationStatsInfoParam;
import com.zjxdqh.face.vo.StationStatsInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  充电站统计信息查询
 * <p>
 *
 * @author PengWei
 * @date 2019/5/10
 */
@Repository
public interface StationStatsInfoMapper {

    List<StationStatsInfo> queryStationStats(StationStatsInfoParam stationStatsInfoParam);
}
