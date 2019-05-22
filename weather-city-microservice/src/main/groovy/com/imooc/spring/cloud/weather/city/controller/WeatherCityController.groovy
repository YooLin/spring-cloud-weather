package com.imooc.spring.cloud.weather.city.controller

import com.imooc.spring.cloud.weather.city.dto.CityDTO
import com.imooc.spring.cloud.weather.city.service.IWeatherCityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author linyicong* @since 2019-05-23
 */
@RestController
@RequestMapping("weather/city")
class WeatherCityController {
    @Autowired
    private IWeatherCityService weatherCityService

    @GetMapping
    List<CityDTO> getAllCityList() {
        return this.weatherCityService.getAllCityList()
    }
}
