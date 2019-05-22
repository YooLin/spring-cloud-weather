package com.imooc.spring.cloud.weather.city.client.fallback

import com.imooc.spring.cloud.weather.city.client.WeatherCityOpenClient
import feign.hystrix.FallbackFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @author linyicong* @since 2019-05-19
 */
@Component
class WeatherCityOpenClientFallbackFactory implements FallbackFactory<WeatherCityOpenClient> {
    private static final WeatherCityOpenClientFallback FALLBACK = new WeatherCityOpenClientFallback()
    private static final Logger logger = LoggerFactory.getLogger(WeatherCityOpenClientFallback)

    @Override
    WeatherCityOpenClient create(Throwable cause) {
        logger.error("error fallback:", cause)
        return FALLBACK
    }
}
