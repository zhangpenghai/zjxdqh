package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.PileGunStateVo;
import com.zjxdqh.face.vo.PileStatusInfoVo;
import com.zjxdqh.face.vo.Subsidy;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import com.zjxdqh.happchargeserver.model.FPileGun;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenshunhua
 * @date 2019/05/10
 */
@Repository
public interface FPileGunMapper extends IBaseMapper<FPileGun> {


    /**
     * 根据充电站id查询充电设备接口状态
     *
     * @param stationID
     * @return
     */
    List<PileStatusInfoVo> getPilesByStationId(@Param("stationID") String stationID);


    /**
     * 根据桩号和枪号查询充电设备接口状态
     *
     * @param pilenum
     * @param gnum
     * @return
     */
    PileStatusInfoVo getPilesByPilegnum(@Param("pilenum") String pilenum, @Param("gnum") String gnum);

    /**
     * 补贴政策(重庆监管平台)
     *
     * @param supersiveId
     * @return
     */
    List<Subsidy> notificationRecordsAmountInfo(@Param("supersiveId") String supersiveId);


    /**
     * 根据桩号和枪号查询充电设备接口状态
     *
     * @param pilenum
     * @param gnum
     * @return
     */
    List<PileStatusInfoVo> getListPileGun(@Param("pilenum") String pilenum, @Param("gnum") String gnum);


    /**
     *
     * 查询充电桩充电枪状态
     * @param pileNum
     * @param gunNum
     * @return
     */
    List<PileGunStateVo>  queryPileGunState(@Param("pileNum") String pileNum, @Param("gunNum") String gunNum);


}
