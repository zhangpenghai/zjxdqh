package com.zjxdqh.face.config;

import feign.RequestTemplate;

/**
 * @author Yorking
 * @date 2019/05/07
 */
public interface FeignInterceptor {

    void apply(RequestTemplate requestTemplate);
}
