package com.zjxdqh.face.enums;

/**
 * @author: wangqinmin
 * @date: 2019/9/10 10:34
 * @description: 仰天大笑出门去，我辈岂是蓬蒿人
 */
public enum AccountTypeEnums implements BaseTypeIntegerEnum {

    /**
     * 0:个人账户付费
     * 1：企业账户付费
     */
    KV_P(0, 3),
    KV_E(1, 5);

    private Integer key;
    private Integer value;

    AccountTypeEnums(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public static Integer getAccountTypeValue(Integer code) {

        if (code == null || "".equals(code)) {
            return null;
        }

        for (AccountTypeEnums e : AccountTypeEnums.values()) {
            if (code.equals(e.getKey())) {
                return e.getValue();
            }
        }
        return null;
    }
}
