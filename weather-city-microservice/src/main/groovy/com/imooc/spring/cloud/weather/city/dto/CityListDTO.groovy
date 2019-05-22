package com.imooc.spring.cloud.weather.city.dto

import groovy.transform.ToString

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * @author yicong* @since 2019-05-22 12:11
 */
@ToString
@XmlRootElement(name = "c")
class CityListDTO {
    @XmlElement(name = "c1")
    List<CityDTO> cityDTOList
}
