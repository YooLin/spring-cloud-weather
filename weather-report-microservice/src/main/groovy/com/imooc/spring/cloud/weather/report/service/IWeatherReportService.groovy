package com.imooc.spring.cloud.weather.report.service

import com.imooc.spring.cloud.weather.common.dto.WeatherDTO

/**
 * @author linyicong* @since 2019-05-22
 */
interface IWeatherReportService {

    WeatherDTO getWeatherDataByCityId(String cityId)
}
