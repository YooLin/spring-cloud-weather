package com.imooc.spring.cloud.weather.data.controller

import com.imooc.spring.cloud.weather.data.dto.WeatherResponseDTO
import com.imooc.spring.cloud.weather.data.service.IWeatherDataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author linyicong* @since 2019-05-20
 */
@RestController
@RequestMapping("weather")
class WeatherDataController {
    @Autowired
    private IWeatherDataService weatherDataService

    @GetMapping("/cityId/{cityId}")
    WeatherResponseDTO getByCityId(@PathVariable String cityId) {
        return this.weatherDataService.getByCityId(cityId)
    }

    @GetMapping("/cityName/{cityName}")
    WeatherResponseDTO getByCityName(@PathVariable String cityName) {
        return this.weatherDataService.getByCityName(cityName)
    }
}
