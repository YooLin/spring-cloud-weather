package com.imooc.spring.cloud.weather.city.service

import com.imooc.spring.cloud.weather.common.dto.CityDTO


/**
 * @author linyicong* @since 2019-05-23
 */
interface IWeatherCityService {
    List<CityDTO> getAllCityList()
}