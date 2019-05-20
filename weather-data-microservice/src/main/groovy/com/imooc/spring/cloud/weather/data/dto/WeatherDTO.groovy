package com.imooc.spring.cloud.weather.data.dto

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.ToString

/**
 * @author linyicong* @since 2019-05-19
 */
@ToString
class WeatherDTO implements Serializable {
    String city
    @JsonProperty(value = "yesterday")
    YesterdayWeatherDTO yesterdayWeatherDTO
    @JsonProperty(value = "forecast")
    List<ForecastWeatherDTO> forecastWeatherDTOList
    @JsonProperty(value = "ganmao")
    String preventionTip
    @JsonProperty(value = "wendu")
    String temperature
}
