package com.imooc.spring.cloud.weather.common.dto


import groovy.transform.ToString

/**
 * @author linyicong* @since 2019-05-19
 */
@ToString
class WeatherResponseDTO {
    WeatherDTO data
    Integer status
    String desc
}
