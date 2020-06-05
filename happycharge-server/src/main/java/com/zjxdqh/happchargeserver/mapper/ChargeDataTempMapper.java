package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.ChargeDataTemp;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangqinmin
 * @since 2019-09-03
 */
@Repository
public interface ChargeDataTempMapper extends IBaseMapper<ChargeDataTemp> {

    ChargeDataTemp getVoltageCurrent(@Param("sn") String sn);
}
