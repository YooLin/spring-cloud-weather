package com.imooc.spring.cloud.data.client

import com.imooc.spring.cloud.data.fallback.WeatherDataClientFallbackFactory
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author linyicong* @since 2019-05-24
 */
@RequestMapping("weather/data")
@FeignClient(name = "weather-data-microservice", fallbackFactory = WeatherDataClientFallbackFactory)
interface WeatherDataClient {
    @GetMapping("/cityName/{cityName}")
    WeatherResponseDTO getByCityName(@PathVariable(value = "cityName") String cityName)

    @GetMapping("/cityId/{cityId}")
    WeatherResponseDTO getByCityId(@PathVariable(value = "cityId") String cityId)
}