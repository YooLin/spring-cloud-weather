package com.imooc.spring.cloud.weather.report.service.impl

import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import com.imooc.spring.cloud.weather.report.client.WeatherDataClient
import com.imooc.spring.cloud.weather.report.service.IWeatherReportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author linyicong* @since 2019-05-22
 */
@Service
class WeatherReportServiceImpl implements IWeatherReportService {

    @Autowired
    private WeatherDataClient weatherDataClient

    @Override
    WeatherResponseDTO getWeatherDataByCityId(String cityId) {
        return this.weatherDataClient.getByCityId(cityId)
    }
}
