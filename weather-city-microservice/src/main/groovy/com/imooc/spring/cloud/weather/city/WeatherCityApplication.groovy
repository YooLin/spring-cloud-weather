package com.imooc.spring.cloud.weather.city

import org.springframework.boot.SpringApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.openfeign.EnableFeignClients

/**
 * todo http://mobile.weather.com.cn/js/citylist.xml
 * @author yicong* @since 2019-05-22 11:57
 */
@EnableFeignClients
@SpringCloudApplication
class WeatherCityApplication {
    static void main(String[] args) {
        SpringApplication.run WeatherCityApplication, args
    }
}
