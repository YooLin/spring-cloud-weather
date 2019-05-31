package com.imooc.spring.cloud.data.fallback


import com.imooc.spring.cloud.data.client.WeatherDataClient
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import org.springframework.web.bind.annotation.PathVariable

/**
 * @author linyicong* @since 2019-05-19
 */
class WeatherDataClientFallback implements WeatherDataClient {
    @Override
    WeatherResponseDTO getByCityName(@PathVariable String cityName) {
        return null
    }

    @Override
    WeatherResponseDTO getByCityId(@PathVariable String cityId) {
        return null
    }
}
