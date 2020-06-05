package com.zjxdqh.face.enums;

/**
 * 配置数据源名称关键字
 * @author Yorking
 * @date 2019/09/17
 */
public enum  DataSourceEnum {

    /**
     * 数据源名称
     */
    HAPPY("happy"),
    COLLECT("collect");

    private String name;

    DataSourceEnum(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
