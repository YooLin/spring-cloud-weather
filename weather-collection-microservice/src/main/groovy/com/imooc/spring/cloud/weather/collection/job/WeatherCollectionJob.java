package com.imooc.spring.cloud.weather.collection.job;


import com.imooc.spring.cloud.city.client.WeatherCityClient;
import com.imooc.spring.cloud.city.dto.CityDTO;
import com.imooc.spring.cloud.weather.collection.service.WeatherCollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author linyicong* @since 2019-05-19
 */
@Component
public class WeatherCollectionJob {
    private static final Logger logger = LoggerFactory.getLogger(WeatherCollectionJob.class);

    @Autowired
    private WeatherCollectionService weatherCollectionService;
    @Autowired
    private WeatherCityClient weatherCityClient;

    @Scheduled(fixedRate = 1800000L)
    void syncWeatherData2Cache() {
        logger.info("sync weather data to cache begin!");

        List<CityDTO> cityIdList = this.weatherCityClient.getAllCityList();
        if (!CollectionUtils.isEmpty(cityIdList)) {
            cityIdList.parallelStream()
                    .map(CityDTO::getCityId)
                    .filter(Objects::nonNull)
                    .forEach(this.weatherCollectionService::saveCityWeatherData);
        }

        logger.info("sync weather data to cache end!");
    }
}
