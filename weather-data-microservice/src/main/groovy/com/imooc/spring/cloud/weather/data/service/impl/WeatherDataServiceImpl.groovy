package com.imooc.spring.cloud.weather.data.service.impl

import com.imooc.spring.cloud.weather.data.client.WeatherOpenClient
import com.imooc.spring.cloud.weather.data.constant.CacheConstants
import com.imooc.spring.cloud.weather.data.dto.WeatherResponseDTO
import com.imooc.spring.cloud.weather.data.service.IWeatherDataService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

/**
 * @author linyicong* @since 2019-05-20
 */
@Service
@CacheConfig(cacheNames = CacheConstants.CITY_WEATHER_KEY)
class WeatherDataServiceImpl implements IWeatherDataService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl)

    @Autowired
    private WeatherOpenClient weatherOpenClient

    @Override
    @Cacheable(key = "#cityId")
    WeatherResponseDTO getByCityId(String cityId) {
        return this.weatherOpenClient.getByCityId(cityId)
    }

    @Override
    @Cacheable(key = "#cityName", condition = "false")
    WeatherResponseDTO getByCityName(String cityName) {
        return this.weatherOpenClient.getByCityName(cityName)
    }
}
