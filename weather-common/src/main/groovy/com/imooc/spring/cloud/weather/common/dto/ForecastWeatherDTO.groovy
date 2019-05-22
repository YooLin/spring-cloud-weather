package com.imooc.spring.cloud.weather.common.dto

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.ToString

/**
 * @author linyicong* @since 2019-05-19
 */
@ToString
class ForecastWeatherDTO implements Serializable {
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
