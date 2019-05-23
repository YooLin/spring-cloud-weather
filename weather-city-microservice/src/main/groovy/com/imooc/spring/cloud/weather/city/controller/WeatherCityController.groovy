package com.imooc.spring.cloud.weather.city.controller

import com.imooc.spring.cloud.city.client.WeatherCityClient
import com.imooc.spring.cloud.city.dto.CityDTO
import com.imooc.spring.cloud.weather.city.service.IWeatherCityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

/**
 * @author linyicong* @since 2019-05-23
 */
@RestController
class WeatherCityController implements WeatherCityClient {
    @Autowired
    private IWeatherCityService weatherCityService

    @Override
    List<CityDTO> getAllCityList() {
        return this.weatherCityService.getAllCityList()
    }
}
