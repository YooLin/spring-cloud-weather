package com.imooc.spring.cloud.weather.data.client.fallback

import com.imooc.spring.cloud.weather.data.client.WeatherOpenClient
import com.imooc.spring.cloud.weather.data.dto.WeatherResponseDTO

/**
 * @author linyicong* @since 2019-05-19
 */
class WeatherOpenClientFallback implements WeatherOpenClient {

    @Override
    WeatherResponseDTO getByCityId(String cityId) {
        return null
    }

    @Override
    WeatherResponseDTO getByCityName(String cityName) {
        return null
    }
}
