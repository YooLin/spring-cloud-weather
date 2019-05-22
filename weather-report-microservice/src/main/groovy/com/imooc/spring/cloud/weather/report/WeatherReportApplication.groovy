package com.imooc.spring.cloud.weather.report

import org.springframework.boot.SpringApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.openfeign.EnableFeignClients

/**
 * @author linyicong* @since 2019-05-22
 */
@EnableFeignClients
@SpringCloudApplication
class WeatherReportApplication {
    static void main(String[] args) {
        SpringApplication.run WeatherReportApplication, args
    }
}
