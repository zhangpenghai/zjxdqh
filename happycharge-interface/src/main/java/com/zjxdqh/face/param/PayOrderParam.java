package com.zjxdqh.face.param;

import com.zjxdqh.face.vo.FCouponsUser;
import com.zjxdqh.face.vo.FOrder;
import com.zjxdqh.face.vo.FOrderSettlement;
import lombok.Data;

/**
 * @author Yorking
 * @date 2019/09/19
 */
@Data
public class PayOrderParam {


    /**
     * 订单信息
     */
    private FOrder order;

    /**
     * 结算信息
     */
    private FOrderSettlement settlement;

    /**
     * 优惠券信息
     */
    private FCouponsUser couponsUser;
}
