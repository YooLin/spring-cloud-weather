package com.imooc.spring.cloud.weather.monitor.turbine.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream

/**
 * @author linyicong* @since 2019-06-11
 */
@EnableTurbineStream
@SpringBootApplication
class WeatherMonitorTurbineServer {
    static void main(String[] args) {
        SpringApplication.run WeatherMonitorTurbineServer, args
    }
}
