package com.imooc.spring.cloud.weather.common.dto

import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

/**
 * @author yicong* @since 2019-05-22 12:11
 */
@ToString
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
class CityDTO {
    @XmlAttribute(name = "d1")
    String cityId
    @XmlAttribute(name = "d2")
    String cityName
    @XmlAttribute(name = "d3")
    String cityEnglishName
    @XmlAttribute(name = "d4")
    String provinceName
}
