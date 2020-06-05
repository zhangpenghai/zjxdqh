package com.zjxdqh.face.enums;

/**
 *
 * 退款原因
 *
 */
public enum RefundReasonEnums implements BaseTypeStringEnum{

    KV_0("1", "无法启动充电"),
    KV_1("2", "充电过程中总是跳枪，体验感差"),
    KV_3("3", "充电流程繁琐，不再使用APP"),
    KV_4("4", "电价贵，其他地方充电便宜"),
    KV_5("5", "电车退（卖）了不再使用充电"),
    KV_6("6", "其他");

    private String key;
    private String value;

    RefundReasonEnums(String key, String value) {
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

    public static String getRefundReason(String key)
    {
        if (key == null || "".equals(key)) {
            return null;
        }

        for(RefundReasonEnums reason:RefundReasonEnums.values())
        {
            if(key.equals(reason.getKey()))
            {
              return reason.getValue();
            }
        }

        return null;

    }




}
