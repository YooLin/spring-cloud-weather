package com.imooc.spring.cloud.weather.collection.client

import com.imooc.spring.cloud.weather.collection.WeatherCollectionApplicationTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author linyicong* @since 2019-05-19
 */
class WeatherOpenClientTest extends WeatherCollectionApplicationTest {
    @Autowired
    private final WeatherOpenClient weatherOpenClient

    @Test
    void testGetByCityId() {
        def result = this.weatherOpenClient.getByCityId("101010100")
        assert result != null
    }
}