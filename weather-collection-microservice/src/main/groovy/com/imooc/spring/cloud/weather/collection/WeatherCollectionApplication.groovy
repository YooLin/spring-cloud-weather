package com.imooc.spring.cloud.weather.collection

import org.springframework.boot.SpringApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

/**
 * @author linyicong* @since 2019-05-19
 */
@ComponentScan(basePackages = "com.imooc.spring.cloud")
@EnableCaching
@EnableScheduling
@EnableFeignClients(basePackages = "com.imooc.spring.cloud")
@SpringCloudApplication
class WeatherCollectionApplication {
    static void main(String[] args) {
        SpringApplication.run WeatherCollectionApplication, args
    }
}
