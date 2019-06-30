package com.imooc.spring.cloud.weather.common.dto

import groovy.transform.ToString

/**
 * @author yicong* @since 2019-05-22 12:11
 */
@ToString
class CityDTO {
    String cityId
    String cityName
    String cityEnglishName
    String provinceName
}
