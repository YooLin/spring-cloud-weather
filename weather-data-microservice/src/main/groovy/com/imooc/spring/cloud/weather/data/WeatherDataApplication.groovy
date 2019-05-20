package com.imooc.spring.cloud.weather.data

import org.springframework.boot.SpringApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.openfeign.EnableFeignClients

/**
 * @author linyicong* @since 2019-05-20
 */
@EnableCaching
@EnableFeignClients
@SpringCloudApplication
class WeatherDataApplication {
    static void main(String[] args) {
        SpringApplication.run WeatherDataApplication, args
    }
}
