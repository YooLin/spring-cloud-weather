package com.imooc.spring.cloud.weather.common.dto

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.ToString

/**
 * @author linyicong* @since 2019-05-19
 */
@ToString
class YesterdayWeatherDTO implements Serializable {
    @JsonProperty(value = "date")
    String dateDesc

    @JsonProperty(value = "high")
    String highTemperatureDesc

    @JsonProperty(value = "fx")
    String windDirection

    @JsonProperty(value = "low")
    String lowTemperatureDesc

    @JsonProperty(value = "fl")
    String windPower

    @JsonProperty(value = "type")
    String weather
}
