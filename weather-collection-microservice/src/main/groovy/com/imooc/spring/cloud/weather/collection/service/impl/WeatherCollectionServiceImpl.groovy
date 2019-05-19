package com.imooc.spring.cloud.weather.collection.service.impl

import com.imooc.spring.cloud.weather.collection.client.WeatherOpenClient
import com.imooc.spring.cloud.weather.collection.constant.CacheConstants
import com.imooc.spring.cloud.weather.collection.dto.WeatherResponseDTO
import com.imooc.spring.cloud.weather.collection.service.WeatherCollectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CachePut
import org.springframework.stereotype.Service

/**
 * @author linyicong* @since 2019-05-19
 */
@Service
class WeatherCollectionServiceImpl implements WeatherCollectionService {
    @Autowired
    WeatherOpenClient weatherOpenClient

    @Override
    @CachePut(cacheNames = CacheConstants.CITY_WEATHER_KEY, key = "#cityId", unless = "#result == null")
    WeatherResponseDTO cacheCityWeatherData(String cityId) {
        return this.weatherOpenClient.getByCityId(cityId)
    }
}
