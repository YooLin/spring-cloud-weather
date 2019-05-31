package com.imooc.spring.cloud.weather.common.dto


import groovy.transform.ToString

/**
 * todo: 1.redis反序列化冲突 2.JsonProperty
 * @author linyicong* @since 2019-05-19
 */
@ToString
class WeatherResponseDTO {
    WeatherDTO data
    Integer status
    String desc
}
