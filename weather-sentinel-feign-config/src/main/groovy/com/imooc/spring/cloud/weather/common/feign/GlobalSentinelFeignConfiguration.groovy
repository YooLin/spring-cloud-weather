package com.imooc.spring.cloud.weather.common.feign

import feign.Feign
import feign.Logger
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cloud.alibaba.sentinel.feign.SentinelFeign
import org.springframework.context.annotation.*

/**
 * 参考
 * https://blog.csdn.net/ttzommed/article/details/90669320
 * https://my.oschina.net/giegie/blog/3013666
 * @author linyicong* @since 2019-08-24
 */
@Configuration
class GlobalSentinelFeignConfiguration {

    @Bean
    @Scope("prototype")
    @ConditionalOnClass([SentinelFeign.class, Feign.class])
    @ConditionalOnProperty(name = "feign.sentinel.enabled")
    @Primary
    Feign.Builder feignHystrixBuilder() {
        return GlobalSentinelFeign.builder()
    }

    @Bean
    @Profile("!prod")
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL
    }
}