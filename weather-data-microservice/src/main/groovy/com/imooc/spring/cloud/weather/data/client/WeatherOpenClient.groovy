package com.imooc.spring.cloud.weather.data.client


import com.imooc.spring.cloud.weather.data.client.fallback.WeatherOpenClientFallbackFactory
import com.imooc.spring.cloud.weather.data.config.FeignConfig
import com.imooc.spring.cloud.weather.data.dto.WeatherResponseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * @author linyicong* @since 2019-05-19
 */
@FeignClient(name = "weather-open-client", url = "http://wthrcdn.etouch.cn", configuration = FeignConfig, fallbackFactory = WeatherOpenClientFallbackFactory)
interface WeatherOpenClient {
    @GetMapping(value = "weather_mini")
    WeatherResponseDTO getByCityId(@RequestParam(name = "citykey") String cityId)

    @GetMapping(value = "weather_mini")
    WeatherResponseDTO getByCityName(@RequestParam(name = "city") String cityName)
}