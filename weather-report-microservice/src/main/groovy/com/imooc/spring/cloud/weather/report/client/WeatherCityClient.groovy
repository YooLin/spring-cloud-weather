package com.imooc.spring.cloud.weather.report.client

import com.imooc.spring.cloud.weather.common.dto.CityDTO

/**
 * @author yicong* @since 2019-05-22 11:43
 */
interface WeatherCityClient {

    List<CityDTO> getCityList()
}
