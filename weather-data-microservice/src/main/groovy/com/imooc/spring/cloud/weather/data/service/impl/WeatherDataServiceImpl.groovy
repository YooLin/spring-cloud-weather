package com.imooc.spring.cloud.weather.data.service.impl

import com.imooc.spring.cloud.weather.data.service.IWeatherDataService
import com.imooc.spring.cloud.weather.common.constant.CacheConstants
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

/**
 * @author linyicong* @since 2019-05-20
 */
@Service
@CacheConfig(cacheNames = CacheConstants.CITY_WEATHER_KEY)
class WeatherDataServiceImpl implements IWeatherDataService {

    @Override
    @Cacheable(key = "#cityId", unless = "#result == null")
    WeatherResponseDTO getByCityId(String cityId) {
        throw new RuntimeException("getByCityId cache missed! cityId=${cityId}")
    }

    @Override
    @Cacheable(key = "#cityName", unless = "#result == null")
    WeatherResponseDTO getByCityName(String cityName) {
        throw new RuntimeException("getByCityName cache missed! cityName=${cityName}")
    }
}
