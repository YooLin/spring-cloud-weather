package com.imooc.spring.cloud.weather.city.service.impl

import com.alicp.jetcache.anno.CachePenetrationProtect
import com.alicp.jetcache.anno.CacheRefresh
import com.alicp.jetcache.anno.CacheType
import com.alicp.jetcache.anno.Cached
import com.imooc.spring.cloud.weather.city.service.IWeatherCityService
import com.imooc.spring.cloud.weather.common.dto.CityDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service

import java.util.concurrent.TimeUnit

/**
 * @author linyicong* @since 2019-05-23
 */
@Service
class WeatherCityServiceImpl implements IWeatherCityService {
    @Value("classpath:cityList.xml")
    private Resource resource

    @Cached(name = "cities", expire = 7, localExpire = 1, timeUnit = TimeUnit.DAYS, localLimit = 200, cacheType = CacheType.BOTH)
    @CacheRefresh(refresh = 5, timeUnit = TimeUnit.SECONDS)
    @CachePenetrationProtect
    @Override
    List<CityDTO> getAllCityList() {
        Node node = new XmlParser().parse(this.resource.getFile())
        List<CityDTO> cityDTOList = node['d'].collect {
            return new CityDTO(
                    cityId: it['@d1'],
                    cityName: it['@d2'],
                    cityEnglishName: it['@d3'],
                    provinceName: it['@d4']
            )
        }
        return cityDTOList == null ? Collections.<CityDTO> emptyList() : cityDTOList
    }
}