package com.imooc.spring.cloud.weather.report.controller

import com.google.common.collect.ImmutableMap
import com.imooc.spring.cloud.gateway.client.WeatherGatewayClient
import com.imooc.spring.cloud.weather.common.dto.CityDTO
import com.imooc.spring.cloud.weather.common.dto.WeatherDTO
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import com.imooc.spring.cloud.weather.report.dto.R
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

/**
 * @author linyicong* @since 2019-05-22
 */
@Controller
@RequestMapping("/weather/report")
class WeatherReportController {
    @Autowired
    private WeatherGatewayClient weatherGatewayClient

    @GetMapping("/cityId/{cityId}")
    ModelAndView getCityWeatherReport(@PathVariable String cityId) {
        List<CityDTO> cityList = this.weatherGatewayClient.getAllCityList()
        WeatherDTO weatherDTO = this.weatherGatewayClient.getDataByCityId(cityId)?.data

        def data = ImmutableMap.builder()
                .put("title", "天气预报")
                .put("cityId", cityId)
                .put("cityList", cityList)
                .put("report", weatherDTO)
                .build()
        return new ModelAndView("/weather/report", "reportModel", data)
    }

    @GetMapping("/cityName/{cityName}")
    @ResponseBody
    R<WeatherDTO> getCityWeatherDTO(@PathVariable String cityName) {
        WeatherResponseDTO weatherResponseDTO = this.weatherGatewayClient.getDataByCityName(cityName)
        return R.success(weatherResponseDTO?.data)
    }
}
