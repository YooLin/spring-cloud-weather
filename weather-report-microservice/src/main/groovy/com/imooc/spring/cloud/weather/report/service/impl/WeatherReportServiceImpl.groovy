package com.imooc.spring.cloud.weather.report.service.impl

import com.imooc.spring.cloud.data.client.WeatherDataClient
import com.imooc.spring.cloud.weather.common.dto.WeatherDTO
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
    WeatherDTO getWeatherDataByCityId(String cityId) {
        return this.weatherDataClient.getByCityId(cityId)?.data
    }
}
