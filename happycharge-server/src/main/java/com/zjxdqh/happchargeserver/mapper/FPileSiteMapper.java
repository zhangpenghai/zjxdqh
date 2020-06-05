package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.FPile;
import com.zjxdqh.face.vo.FPileSite;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Yorking
 * @date 2019/05/08
 */
@Repository
public interface FPileSiteMapper extends IBaseMapper<FPileSite> {

    /**
     * 获取 监管对应的 场站
     *
     * @return
     */
    List<FPileSite> getSuperviseSite(@Param("operatorId") String  operatorId);

    List<FPile> getSupervisePile(@Param("sids") List<Integer> sids, @Param("startTime") Date startTime);


}
