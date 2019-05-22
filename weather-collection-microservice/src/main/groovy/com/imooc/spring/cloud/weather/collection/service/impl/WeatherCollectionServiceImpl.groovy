package com.imooc.spring.cloud.weather.collection.service.impl

import com.imooc.spring.cloud.weather.collection.client.WeatherOpenClient
import com.imooc.spring.cloud.weather.collection.service.WeatherCollectionService
import com.imooc.spring.cloud.weather.common.constant.CacheConstants
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Caching
import org.springframework.stereotype.Service

/**
 * @author linyicong* @since 2019-05-19
 */
@Service
@CacheConfig(cacheNames = CacheConstants.CITY_WEATHER_KEY)
class WeatherCollectionServiceImpl implements WeatherCollectionService {
    @Autowired
    WeatherOpenClient weatherOpenClient

    @Override
    @Caching(put = [
            @CachePut(key = "#cityId", unless = "#result == null"),
            @CachePut(key = "#result.data.city", unless = "#result == null")
    ])
    WeatherResponseDTO cacheCityWeatherData(String cityId) {
        return this.weatherOpenClient.getByCityId(cityId)
    }
}
