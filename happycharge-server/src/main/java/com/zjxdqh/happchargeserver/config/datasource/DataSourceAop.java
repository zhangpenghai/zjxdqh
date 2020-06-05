package com.zjxdqh.happchargeserver.config.datasource;

import com.zjxdqh.face.enums.DataSource;
import com.zjxdqh.tools.datasource.DataSourceContextHolder;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Yorking
 * @date 2019/09/17
 */
@Component
@Log4j2
@Aspect
@Order(-1)
public class DataSourceAop {

    @Pointcut("@annotation(com.zjxdqh.face.enums.DataSource)")
    public void pointCut(){

    }

    @Before("pointCut() && @annotation(dataSource)")
    public void doBefore(DataSource dataSource){
        log.info("选择数据源---"+dataSource.value());
        DataSourceContextHolder.setDataSource(dataSource.value().getName());
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clear();
    }
}
