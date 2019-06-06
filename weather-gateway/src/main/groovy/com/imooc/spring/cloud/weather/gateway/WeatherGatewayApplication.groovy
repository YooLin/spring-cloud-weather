package com.imooc.spring.cloud.weather.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 * @author linyicong* @since 2019-06-05
 */
@EnableDiscoveryClient
@SpringBootApplication
class WeatherGatewayApplication {
    static void main(String[] args) {
        SpringApplication.run WeatherGatewayApplication, args
    }
}
