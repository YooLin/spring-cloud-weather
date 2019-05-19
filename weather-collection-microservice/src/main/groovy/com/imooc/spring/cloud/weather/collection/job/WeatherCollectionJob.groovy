package com.imooc.spring.cloud.weather.collection.job

import com.google.common.collect.Lists
import com.imooc.spring.cloud.weather.collection.service.WeatherCollectionService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/**
 * @author linyicong* @since 2019-05-19
 */
@Component
class WeatherCollectionJob {
    private static final Logger logger = LoggerFactory.getLogger(WeatherCollectionJob)

    @Autowired
    WeatherCollectionService weatherCollectionService

    @Scheduled(fixedRate = 1800000L)
    void syncWeatherData2Cache() {
        logger.info("sync weather data to cache begin!")

        def cityIdList = Lists.newArrayList("101010100")
        cityIdList.each { this.weatherCollectionService.cacheCityWeatherData(it) }

        logger.info("sync weather data to cache end!")
    }
}
