package com.zjxdqh.face.enums;

import java.lang.annotation.*;

/**
 *
 * 多数据源时， 配置数据源名称
 *
 * @author Yorking
 * @date 2019/09/17
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceEnum value() default DataSourceEnum.HAPPY;
}
