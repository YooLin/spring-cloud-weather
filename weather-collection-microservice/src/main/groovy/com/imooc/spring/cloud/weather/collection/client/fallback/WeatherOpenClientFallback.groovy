package com.imooc.spring.cloud.weather.collection.client.fallback

import com.imooc.spring.cloud.weather.collection.client.WeatherOpenClient
import com.imooc.spring.cloud.weather.collection.dto.WeatherResponseDTO

/**
 * @author linyicong* @since 2019-05-19
 */
class WeatherOpenClientFallback implements WeatherOpenClient {

    @Override
    WeatherResponseDTO getByCityId(String cityId) {
        return null
    }
}
