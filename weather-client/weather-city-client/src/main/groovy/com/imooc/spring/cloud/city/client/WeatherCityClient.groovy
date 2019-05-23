package com.imooc.spring.cloud.city.client

import com.imooc.spring.cloud.city.dto.CityDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author linyicong* @since 2019-05-24
 */
@RequestMapping("weather/city")
@FeignClient(name = "weather-city-microservice")
interface WeatherCityClient {
    @GetMapping
    List<CityDTO> getAllCityList()
}