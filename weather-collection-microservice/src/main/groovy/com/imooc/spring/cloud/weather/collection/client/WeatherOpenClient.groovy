package com.imooc.spring.cloud.weather.collection.client

import com.imooc.spring.cloud.weather.collection.client.fallback.WeatherOpenClientFallbackFactory
import com.imooc.spring.cloud.weather.collection.config.WeatherOpenClientConfig
import com.imooc.spring.cloud.weather.collection.dto.WeatherResponseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * @author linyicong* @since 2019-05-19
 */
@FeignClient(name = "weather-open-client", url = "http://wthrcdn.etouch.cn", configuration = WeatherOpenClientConfig, fallbackFactory = WeatherOpenClientFallbackFactory)
interface WeatherOpenClient {
    @GetMapping(value = "weather_mini")
    WeatherResponseDTO getByCityId(@RequestParam(name = "citykey") String cityId)
}
