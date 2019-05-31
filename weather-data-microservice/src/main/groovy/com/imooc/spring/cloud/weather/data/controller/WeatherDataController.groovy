package com.imooc.spring.cloud.weather.data.controller

import com.imooc.spring.cloud.data.client.WeatherDataClient
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import com.imooc.spring.cloud.weather.data.service.IWeatherDataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

/**
 * @author linyicong* @since 2019-05-20
 */
@RestController
class WeatherDataController implements WeatherDataClient {
    @Autowired
    private IWeatherDataService weatherDataService

    @Override
    WeatherResponseDTO getByCityId(String cityId) {
        return this.weatherDataService.getByCityId(cityId)
    }

    @Override
    WeatherResponseDTO getByCityName(String cityName) {
        return this.weatherDataService.getByCityName(cityName)
    }
}
