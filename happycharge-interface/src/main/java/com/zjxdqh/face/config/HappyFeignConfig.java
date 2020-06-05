package com.zjxdqh.face.config;

import com.zjxdqh.tools.annon.ExcludeComponentScan;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yorking
 * @date 2019/05/07
 */
@Configuration
@ExcludeComponentScan
public class HappyFeignConfig {

    @Autowired(required = false)
    @Qualifier(value = "feignInterceptor")
    private FeignInterceptor feignInterceptor;

    @Bean("requestInterceptor")
    public RequestInterceptor requestInterceptor() {
        if (feignInterceptor == null) {
            feignInterceptor = getFeignInterceptor();
        }
        return requestTemplate -> feignInterceptor.apply(requestTemplate);
    }

    @Bean("DefaultHappyFeignInterceptor2")
    public FeignInterceptor getFeignInterceptor() {
        return requestTemplate -> {};
    }
}
