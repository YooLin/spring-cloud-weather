package com.imooc.spring.cloud.weather.city.dto

import groovy.transform.ToString

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * @author yicong* @since 2019-05-22 12:11
 */
@ToString
@XmlRootElement(name = "d")
class CityDTO {
    @XmlElement(name = "d1")
    String cityCode
    @XmlElement(name = "d2")
    String cityName
    @XmlElement(name = "d3")
    String cityEnglishName
    @XmlElement(name = "d4")
    String provinceName
}
