package com.imooc.spring.cloud.weather.data.controller

import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
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
@RequestMapping("weather/data")
class WeatherDataController {
    @Autowired
    private IWeatherDataService weatherDataService

    @GetMapping("/cityName/{cityName}")
    WeatherResponseDTO getByCityId(@PathVariable(value = "cityName") String cityId) {
        return this.weatherDataService.getByCityId(cityId)
    }

    @GetMapping("/cityId/{cityId}")
    WeatherResponseDTO getByCityName(@PathVariable(value = "cityId") String cityName) {
        return this.weatherDataService.getByCityName(cityName)
    }
}
