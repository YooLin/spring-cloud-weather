package com.imooc.spring.cloud.weather.monitor.dashboard

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

/**
 * @author linyicong* @since 2019-06-09
 */
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
class WeatherMonitorDashboardApplication {
    static void main(String[] args) {
        SpringApplication.run WeatherMonitorDashboardApplication, args
    }
}
