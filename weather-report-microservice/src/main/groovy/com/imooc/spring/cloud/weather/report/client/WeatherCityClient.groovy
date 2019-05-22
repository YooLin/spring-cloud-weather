package com.imooc.spring.cloud.weather.report.client

import com.imooc.spring.cloud.weather.common.dto.CityDTO
import org.springframework.cloud.openfeign.FeignClient

/**
 * todo
 * @author yicong* @since 2019-05-22 11:43
 */
@FeignClient(name="weather-city-client")
interface WeatherCityClient {

    List<CityDTO> getCityList()
}
