package com.imooc.spring.cloud.gateway.fallback


import com.imooc.spring.cloud.gateway.client.WeatherGatewayClient
import com.imooc.spring.cloud.weather.common.dto.CityDTO
import com.imooc.spring.cloud.weather.common.dto.WeatherResponseDTO
import org.springframework.web.bind.annotation.PathVariable

/**
 * @author linyicong* @since 2019-05-19
 */
class WeatherGatewayClientFallback implements WeatherGatewayClient {
    @Override
    WeatherResponseDTO getByCityName(@PathVariable String cityName) {
        return null
    }

    @Override
    WeatherResponseDTO getDataByCityId(@PathVariable String cityId) {
        return null
    }

    @Override
    List<CityDTO> getAllCityList() {
        return Collections.emptyList()
    }
}
