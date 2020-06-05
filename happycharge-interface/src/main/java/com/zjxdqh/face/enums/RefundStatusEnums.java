package com.zjxdqh.face.enums;

/**
 *
 * 确认申请退款接口状态
 *
 *
 */
public enum RefundStatusEnums implements BaseTypeStringEnum{


    /**
     *
     *  0-退款中，1-退款成功，2-退款失败
     *
     */
    KV_0("0", "退款中"),
    KV_1("1", "退款成功"),
    KV_2("2", "退款失败");

    private String key;
    private String value;

    RefundStatusEnums(String key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }




}
