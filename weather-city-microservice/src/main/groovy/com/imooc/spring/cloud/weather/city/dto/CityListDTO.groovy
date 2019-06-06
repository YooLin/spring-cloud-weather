package com.imooc.spring.cloud.weather.city.dto


import com.imooc.spring.cloud.weather.common.dto.CityDTO
import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * @author yicong* @since 2019-05-22 12:11
 */
@ToString
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
class CityListDTO {
    @XmlElement(name = "d")
    List<CityDTO> data
}
