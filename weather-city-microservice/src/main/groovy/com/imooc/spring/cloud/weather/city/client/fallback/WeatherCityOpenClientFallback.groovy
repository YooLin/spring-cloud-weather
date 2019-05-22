package com.imooc.spring.cloud.weather.city.client.fallback

import com.imooc.spring.cloud.weather.city.client.WeatherCityOpenClient
import com.imooc.spring.cloud.weather.city.dto.CityInfoDTO

/**
 * @author linyicong* @since 2019-05-19
 */
class WeatherCityOpenClientFallback implements WeatherCityOpenClient {

    @Override
    CityInfoDTO getAllCityList() {
        return null
    }
}
