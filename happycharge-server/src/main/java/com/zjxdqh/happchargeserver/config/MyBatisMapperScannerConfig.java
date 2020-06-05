
package com.zjxdqh.happchargeserver.config;

import com.zjxdqh.happchargeserver.config.frame.IBaseMapper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * MyBatis扫描接口，使用的tk.mybatis.spring.mapper.MapperScannerConfigurer，如果你不使用通用Mapper，可以改为org.xxx...
 *
 * @author yaweiXu
 */
@Configuration
// 注意，由于MapperScannerConfigurer执行的比较早，所以必须指定在mybatis 配置后面

@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //多个包用英文逗号分隔
        mapperScannerConfigurer.setBasePackage("com.zjxdqh.happchargeserver.mapper");
        Properties properties = new Properties();

        properties.setProperty("mappers", IBaseMapper.class.getName());

        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "select replace(uuid(),'-','') from dual");
        properties.setProperty("ORDER", "BEFORE");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}
