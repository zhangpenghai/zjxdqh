package com.zjxdqh.happchargeserver.mapper;



import com.zjxdqh.face.vo.FRefundRecord;
import com.zjxdqh.face.vo.RefundRecordVo;
import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * mapper接口,自定义方法写入此接口,并在xml中实现
 * @author code_generator
 */
@Repository
public interface FRefundRecordMapper extends IBaseMapper<FRefundRecord> {


    List<RefundRecordVo>  getPageList(@Param("uid") Integer uid);


}
