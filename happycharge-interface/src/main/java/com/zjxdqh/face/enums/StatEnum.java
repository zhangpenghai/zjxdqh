package com.zjxdqh.face.enums;

/**
 * STAT常量枚举
 *
 * @author Yorking
 * @date 2019/09/11
 */
public enum StatEnum {
    /**
     * STAT常量枚举
     */
    DISABLE(0, "禁用"),
    ENABLE(1, "使用");

    private String desc;
    private int key;

    StatEnum(int key, String desc) {
        this.desc = desc;
        this.key = key;
    }

    public int key() {
        return this.key;
    }

}
