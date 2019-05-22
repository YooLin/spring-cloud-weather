package com.imooc.spring.cloud.weather.city.client

import com.imooc.spring.cloud.weather.city.WeatherCityApplicationTest
import com.imooc.spring.cloud.weather.city.dto.CityListDTO
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
        CityListDTO cityList = this.weatherCityOpenClient.getCityList()
        assert cityList != null
        assert cityList.cityDTOList.size() > 0
    }

}
