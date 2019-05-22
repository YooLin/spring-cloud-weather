package com.imooc.spring.cloud.weather.collection.client.fallback

import com.imooc.spring.cloud.weather.collection.client.WeatherDataOpenClient
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO

/**
 * @author linyicong* @since 2019-05-19
 */
class WeatherDataOpenClientFallback implements WeatherDataOpenClient {

    @Override
    WeatherResponseDTO getByCityId(String cityId) {
        return null
    }
}
