package com.imooc.spring.cloud.weather.city.client

import com.imooc.spring.cloud.weather.city.client.fallback.WeatherCityOpenClientFallbackFactory
import com.imooc.spring.cloud.weather.city.config.FeignConfig
import com.imooc.spring.cloud.weather.city.dto.CityInfoDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author yicong* @since 2019-05-22 12:17
 */
@FeignClient(name = "weather-city-open-client", url = "http://mobile.weather.com.cn", configuration = FeignConfig, fallbackFactory = WeatherCityOpenClientFallbackFactory)
interface WeatherCityOpenClient {
    @GetMapping(value = "js/citylist.xml")
    CityInfoDTO getAllCityList()
}
