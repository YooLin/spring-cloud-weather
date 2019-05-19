package com.imooc.spring.cloud.weather.collection.dto

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.ToString

/**
 * @author linyicong* @since 2019-05-19
 */
@ToString
class ForecastWeatherDTO {
    @JsonProperty(value = "date")
    String dateDesc

    @JsonProperty(value = "high")
    String highTemperatureDesc

    @JsonProperty(value = "fengli")
    String windPower

    @JsonProperty(value = "low")
    String lowTemperatureDesc

    @JsonProperty(value = "fengxiang")
    String windDirection

    @JsonProperty(value = "type")
    String weather
}
