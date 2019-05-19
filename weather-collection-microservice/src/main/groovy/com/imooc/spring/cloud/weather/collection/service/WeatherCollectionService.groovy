package com.imooc.spring.cloud.weather.collection.service

import com.imooc.spring.cloud.weather.collection.dto.WeatherResponseDTO

/**
 * @author linyicong* @since 2019-05-19
 */
interface WeatherCollectionService {
    WeatherResponseDTO cacheCityWeatherData(String cityId)
}