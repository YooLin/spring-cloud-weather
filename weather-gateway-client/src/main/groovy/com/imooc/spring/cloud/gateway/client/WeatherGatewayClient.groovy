package com.imooc.spring.cloud.gateway.client

import com.imooc.spring.cloud.gateway.fallback.WeatherGatewayClientFallbackFactory
import com.imooc.spring.cloud.weather.common.dto.CityDTO
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author linyicong* @since 2019-05-24
 */
@RequestMapping("weather")
@FeignClient(name = "weather-gateway", fallbackFactory = WeatherGatewayClientFallbackFactory)
interface WeatherGatewayClient {
    @GetMapping("/data/cityName/{cityName}")
    WeatherResponseDTO getDataByCityName(@PathVariable(value = "cityName") String cityName)

    @GetMapping("/data/cityId/{cityId}")
    WeatherResponseDTO getDataByCityId(@PathVariable(value = "cityId") String cityId)

    @GetMapping("/city")
    List<CityDTO> getAllCityList()
}