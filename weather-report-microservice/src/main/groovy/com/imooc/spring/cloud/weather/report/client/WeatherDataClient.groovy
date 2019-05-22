package com.imooc.spring.cloud.weather.report.client

import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import org.springframework.cloud.openfeign.FeignClient

/**
 * todo
 * @author yicong* @since 2019-05-22 11:49
 */
@FeignClient(name = "weather-data-client")
interface WeatherDataClient {
    WeatherResponseDTO getByCityId(String cityId)
}
