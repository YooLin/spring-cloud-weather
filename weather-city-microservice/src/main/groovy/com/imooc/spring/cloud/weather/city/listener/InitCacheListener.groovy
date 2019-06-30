package com.imooc.spring.cloud.weather.city.listener


import com.imooc.spring.cloud.weather.city.service.IWeatherCityService
import com.imooc.spring.cloud.weather.common.dto.CityDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

/**
 * @author linyicong* @since 2019-06-07
 */
@Component
class InitCacheListener {
    private static final Logger logger = LoggerFactory.getLogger(InitCacheListener)

    @Autowired
    private IWeatherCityService weatherCityService

    @EventListener(value = ApplicationStartedEvent.class)
    void initCityCache() {
        logger.info("application started!init city cache begin!")

        List<CityDTO> result = this.weatherCityService.getAllCityList()
        logger.info("application started!init cache result is ${result}")

        logger.info("application started!init city cache end!")
    }
}
