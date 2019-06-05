package com.imooc.spring.cloud.weather.city.service.impl


import com.imooc.spring.cloud.city.dto.CityDTO
import com.imooc.spring.cloud.weather.city.client.WeatherCityOpenClient
import com.imooc.spring.cloud.weather.city.dto.CityInfoDTO
import com.imooc.spring.cloud.weather.city.service.IWeatherCityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author linyicong* @since 2019-05-23
 */
@Service
class WeatherCityServiceImpl implements IWeatherCityService {
    @Autowired
    private WeatherCityOpenClient weatherCityOpenClient

    @Override
    List<CityDTO> getAllCityList() {
        CityInfoDTO cityInfoDTO = this.weatherCityOpenClient.getAllCityList()
        return cityInfoDTO?.cityListDTO?.data
    }
}
