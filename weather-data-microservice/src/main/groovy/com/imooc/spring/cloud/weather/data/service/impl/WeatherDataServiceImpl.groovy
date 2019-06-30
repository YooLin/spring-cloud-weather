package com.imooc.spring.cloud.weather.data.service.impl

import com.imooc.spring.cloud.weather.common.constant.CacheConstants
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import com.imooc.spring.cloud.weather.data.service.IWeatherDataService
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

/**
 * 此处仅从缓存中获取天气数据，若缓存中无数据则视为异常情况！
 * PS：此处不进行任何写缓存操作，缓存数据的写入由天气采集服务提供（具体见weather-collection-microservice模块的WeatherCollectionService实现）
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
