package com.imooc.spring.cloud.weather.city.dto

import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * @author linyicong* @since 2019-05-22
 */
@ToString
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
class CityInfoDTO {
    @XmlElement(name = "c")
    CityListDTO cityListDTO
}
