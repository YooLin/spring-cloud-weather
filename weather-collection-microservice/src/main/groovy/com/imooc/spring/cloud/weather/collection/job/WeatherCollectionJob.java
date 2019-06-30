package com.imooc.spring.cloud.weather.collection.job;


import com.imooc.spring.cloud.city.client.WeatherCityClient;
import com.imooc.spring.cloud.weather.collection.service.WeatherCollectionService;
import com.imooc.spring.cloud.weather.common.dto.CityDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author linyicong* @since 2019-05-19
 */
@Slf4j
@Component
@AllArgsConstructor
public class WeatherCollectionJob {
    private WeatherCollectionService weatherCollectionService;
    private WeatherCityClient weatherCityClient;

    @Scheduled(fixedRate = 30 * 60 * 1000L)
    void syncWeatherData2Cache() {
        log.info("sync weather data to cache begin!");

        List<CityDTO> cityIdList = this.weatherCityClient.getAllCityList();

        if (!CollectionUtils.isEmpty(cityIdList)) {
            cityIdList.parallelStream()
                    .map(CityDTO::getCityId)
                    .filter(Objects::nonNull)
                    .forEach(this.weatherCollectionService::saveCityWeatherData);
        }

        log.info("sync weather data to cache end!");
    }
}
