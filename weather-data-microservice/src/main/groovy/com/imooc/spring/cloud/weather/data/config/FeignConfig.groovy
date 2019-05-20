package com.imooc.spring.cloud.weather.data.config

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author linyicong* @since 2019-05-19
 */
@Configuration
class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL
    }
}
