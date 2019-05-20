package com.imooc.spring.cloud.weather.data.service

import com.imooc.spring.cloud.weather.data.dto.WeatherResponseDTO

/**
 * @author linyicong* @since 2019-05-20
 */
interface IWeatherDataService {
    WeatherResponseDTO getByCityId(String cityId)

    WeatherResponseDTO getByCityName(String cityName)
}
