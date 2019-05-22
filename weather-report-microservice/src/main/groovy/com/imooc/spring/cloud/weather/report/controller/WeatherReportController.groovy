package com.imooc.spring.cloud.weather.report.controller

import com.imooc.spring.cloud.weather.common.dto.CityDTO
import com.imooc.spring.cloud.weather.common.dto.WeatherDTO
import com.imooc.spring.cloud.weather.report.client.WeatherCityClient
import com.imooc.spring.cloud.weather.report.service.IWeatherReportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author linyicong* @since 2019-05-22
 */
@Controller
@RequestMapping("weather/report")
class WeatherReportController {

    @Autowired
    private WeatherCityClient weatherCityClient
    @Autowired
    private IWeatherReportService weatherReportService

    @GetMapping("cityId/{cityId}")
    String report(@PathVariable String cityId, Model model) {
        List<CityDTO> cityList = this.weatherCityClient.getCityList()
        WeatherDTO weatherDTO = this.weatherReportService.getWeatherDataByCityId(cityId)

        model.addAttribute("title", "天气预报")
        model.addAttribute("cityId", cityId)
        model.addAttribute("cityList", cityList)
        model.addAttribute("report", weatherDTO)
        return "weather/report"
    }
}
