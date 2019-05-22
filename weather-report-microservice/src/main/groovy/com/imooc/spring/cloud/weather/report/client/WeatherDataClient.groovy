package com.imooc.spring.cloud.weather.report.client

import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO

/**
 * @author yicong* @since 2019-05-22 11:49
 */
interface WeatherDataClient {
    WeatherResponseDTO getByCityId(String cityId)
}
