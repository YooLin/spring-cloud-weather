package com.imooc.spring.cloud.weather.city.service.impl

import com.imooc.spring.cloud.weather.common.dto.CityDTO
import org.junit.Test
import org.springframework.util.Assert
import org.springframework.util.ResourceUtils

/**
 * @author linyicong* @since 2019-06-30
 */
class WeatherCityServiceImplTest {
    @Test
    void getAllCityList() {
        File file = ResourceUtils.getFile("classpath:cityList.xml")
        Node node = new XmlParser().parse(file)

        List<CityDTO> cityDTOList = node['d'].collect {
            return new CityDTO(
                    cityId: it['@d1'],
                    cityName: it['@d2'],
                    cityEnglishName: it['@d3'],
                    provinceName: it['@d4']
            )
        }
        Assert.notEmpty(cityDTOList, "获取城市列表的数据为空！")
    }
}