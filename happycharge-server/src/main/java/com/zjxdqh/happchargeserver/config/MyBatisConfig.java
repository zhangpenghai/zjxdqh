package com.zjxdqh.happchargeserver.config;

import com.github.miemiedev.mybatis.paginator.OffsetLimitInterceptor;
import com.github.pagehelper.PageHelper;
import com.zjxdqh.happchargeserver.config.datasource.CollectDatasourceConfig;
import com.zjxdqh.face.enums.DataSourceEnum;
import com.zjxdqh.happchargeserver.config.datasource.HappyDatasourceConfig;
import com.zjxdqh.happchargeserver.config.datasource.MultipleDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@AutoConfigureAfter({CollectDatasourceConfig.class, HappyDatasourceConfig.class})
public class MyBatisConfig {

    private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);


    /**
     * 动态数据源配置
     *
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(DataSource happyDataSource, DataSource collectDataSource) {
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceEnum.COLLECT.getName(), collectDataSource);
        targetDataSources.put(DataSourceEnum.HAPPY.getName(), happyDataSource);
        //添加数据源
        multipleDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        multipleDataSource.setDefaultTargetDataSource(happyDataSource);
        return multipleDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource multipleDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        try {
            sessionFactory.setDataSource(multipleDataSource);
            //sessionFactory.setConfigLocation(new InputStreamResource(this.getClass().getResourceAsStream("/mybatis-config.xml")));
            //分页插件
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("reasonable", "true");
            properties.setProperty("supportMethodsArguments", "true");
            properties.setProperty("returnPageInfo", "check");
            properties.setProperty("params", "count=countSql");
            pageHelper.setProperties(properties);


            Interceptor[] interceptor = {pageHelper, offsetLimitInterceptor()};
            sessionFactory.setPlugins(interceptor);

            //添加XML目录
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            sessionFactory.setMapperLocations(resolver.getResources("classpath*:com/zjxdqh/happchargeserver/mapper/*.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory.getObject();
    }

    @Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        logger.debug("---------> Set SqlSessionTemplate");
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    public OffsetLimitInterceptor offsetLimitInterceptor() throws Exception {
        OffsetLimitInterceptor offsetLimitInterceptor = new OffsetLimitInterceptor();
        offsetLimitInterceptor.setDialectClass("com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect");
        return offsetLimitInterceptor;
    }


}
