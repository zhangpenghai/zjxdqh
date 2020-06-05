package com.zjxdqh.happchargeserver.mapper;

import com.zjxdqh.face.vo.FPileTimePrice;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * mapper接口,自定义方法写入此接口,并在xml中实现
 *
 * @author code_generator
 */
@Repository
public interface FPileTimePriceMapper extends IBaseMapper<FPileTimePrice> {

    List<FPileTimePrice> getPolicyInfos(@Param("pilenum") String pilenum);

    /**
     *
     * 查询当前时段电价信息
     * @param map
     * @return
     */
    FPileTimePrice selectTime(Map map);

}
