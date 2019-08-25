package com.imooc.spring.cloud.weather.collection.client

import com.imooc.spring.cloud.weather.collection.client.fallback.WeatherDataOpenClientFallbackFactory
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * @author linyicong* @since 2019-05-19
 */
@FeignClient(name = "weather-data-open-client", url = "http://wthrcdn.etouch.cn", fallbackFactory = WeatherDataOpenClientFallbackFactory)
interface WeatherDataOpenClient {
    @GetMapping(value = "weather_mini")
    WeatherResponseDTO getByCityId(@RequestParam(name = "citykey") String cityId)
}
