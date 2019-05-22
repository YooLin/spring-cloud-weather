package com.imooc.spring.cloud.weather.city.client.fallback

import com.imooc.spring.cloud.weather.city.client.WeatherCityOpenClient
import com.imooc.spring.cloud.weather.city.dto.CityListDTO

/**
 * @author linyicong* @since 2019-05-19
 */
class WeatherCityOpenClientFallback implements WeatherCityOpenClient {

    @Override
    CityListDTO getCityList() {
        return null
    }
}
