package com.imooc.spring.cloud.city.client

import com.imooc.spring.cloud.weather.common.constant.ServiceNameConstants
import com.imooc.spring.cloud.weather.common.dto.CityDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author linyicong* @since 2019-05-24
 */
@FeignClient(name = ServiceNameConstants.CITY_SERVICE)
interface WeatherCityClient {
    @GetMapping
    List<CityDTO> getAllCityList()
}