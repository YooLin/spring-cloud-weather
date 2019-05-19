package com.imooc.spring.cloud.weather.collection.config

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author linyicong* @since 2019-05-19
 */
@Configuration
class WeatherOpenClientConfig {
    @Bean
    Logger.Level weatherOpenClientLoggerLevel() {
        return Logger.Level.FULL
    }
}
