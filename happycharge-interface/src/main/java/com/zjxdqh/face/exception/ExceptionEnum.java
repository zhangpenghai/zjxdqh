package com.zjxdqh.face.exception;

/**
 *
 * 业务异常的枚举定义
 *
 * @author Yorking
 * @date 2019/08/12
 */
public enum ExceptionEnum {

    /**
     *
     */
    ERROR_PARAM(0, "参数传递错误"),
    ERROR_GUN_STAT(100, "枪状态错误"),
    BALANCE_LACK(101, "帐户余额不足"),
    PAY_ERROR(102, "订单支付失败"),
    PAY_ERROR_COUPON(104, "订单支付失败,存在可使用优惠券"),
    GUN_NOT_CONNET(103, "枪未连接");


    private int code;

    private String msg;

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ExceptionEnum getExcep(int code) {
        for (ExceptionEnum value : ExceptionEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}
