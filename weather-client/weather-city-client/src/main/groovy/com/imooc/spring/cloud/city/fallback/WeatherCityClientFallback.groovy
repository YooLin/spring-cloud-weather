package com.imooc.spring.cloud.city.fallback

import com.imooc.spring.cloud.city.client.WeatherCityClient
import com.imooc.spring.cloud.city.dto.CityDTO

/**
 * @author linyicong* @since 2019-05-19
 */
class WeatherCityClientFallback implements WeatherCityClient {

    @Override
    List<CityDTO> getAllCityList() {
        return Collections.emptyList()
    }
}
