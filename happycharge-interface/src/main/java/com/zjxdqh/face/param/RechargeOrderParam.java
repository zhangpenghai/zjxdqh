package com.zjxdqh.face.param;

import com.zjxdqh.face.param.page.PageParam;
import lombok.Data;

/**
 * 充值记录 参数
 * @author chenshunhua
 * @date 2019/09/10
 */
@Data
public class RechargeOrderParam extends PageParam{


    /**
     * 充电用户ID
     */
    private Integer userId;



}
