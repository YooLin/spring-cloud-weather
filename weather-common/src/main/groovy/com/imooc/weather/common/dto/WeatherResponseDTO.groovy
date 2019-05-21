package com.imooc.weather.common.dto

import groovy.transform.ToString

/**
 * @author linyicong* @since 2019-05-19
 */
@ToString
class WeatherResponseDTO implements Serializable {
    WeatherDTO data
    Integer status
    String desc
}
