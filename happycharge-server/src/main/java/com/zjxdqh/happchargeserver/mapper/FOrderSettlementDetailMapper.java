package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.FOrderSettlementDetail;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 结算订单明细 Mapper 接口
 * </p>
 *
 * @author wangqinmin
 * @since 2019-09-05
 */
@Repository
public interface FOrderSettlementDetailMapper extends IBaseMapper<FOrderSettlementDetail> {

    /**
     * 根据ID获取查询对象
     *
     * @param sn
     * @return
     */
    List<FOrderSettlementDetail> getFOrderSettlementDetailBySn(@Param("sn") String sn);

}
