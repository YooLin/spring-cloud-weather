package com.imooc.spring.cloud.weather.city.client

import com.imooc.spring.cloud.weather.city.WeatherCityApplicationTest
import com.imooc.spring.cloud.weather.city.dto.CityInfoDTO
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author yicong* @since 2019-05-22 13:17
 */
class WeatherCityOpenClientTest extends WeatherCityApplicationTest {
    @Autowired
    private WeatherCityOpenClient weatherCityOpenClient

    @Test
    void testGetCityList() {
        CityInfoDTO cityInfoDTO = this.weatherCityOpenClient.getAllCityList()

        assert cityInfoDTO != null
        assert cityInfoDTO.cityListDTO.data.size() > 0
    }

}
