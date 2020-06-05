package com.zjxdqh.happchargeserver.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author: yaweiXu
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.collect")
public class CollectDatasourceConfig extends AbstractDatasourceConfig {

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource collectDataSource() throws SQLException {
        return dataSource();
    }

}
