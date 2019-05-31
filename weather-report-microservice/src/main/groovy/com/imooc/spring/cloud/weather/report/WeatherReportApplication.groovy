package com.imooc.spring.cloud.weather.report

import org.springframework.boot.SpringApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan

/**
 * @author linyicong* @since 2019-05-22
 */
@ComponentScan(basePackages = "com.imooc.spring.cloud")
@EnableFeignClients(basePackages = "com.imooc.spring.cloud")
@SpringCloudApplication
class WeatherReportApplication {
    static void main(String[] args) {
        SpringApplication.run WeatherReportApplication, args
    }
}
