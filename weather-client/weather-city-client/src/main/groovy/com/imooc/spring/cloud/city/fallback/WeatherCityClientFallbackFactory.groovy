package com.imooc.spring.cloud.city.fallback

import com.imooc.spring.cloud.city.client.WeatherCityClient
import feign.hystrix.FallbackFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @author linyicong* @since 2019-05-19
 */
@Component
class WeatherCityClientFallbackFactory implements FallbackFactory<WeatherCityClient> {
    private static final WeatherCityClientFallback FALLBACK = new WeatherCityClientFallback()
    private static final Logger logger = LoggerFactory.getLogger(WeatherCityClientFallbackFactory)

    @Override
    WeatherCityClient create(Throwable cause) {
        logger.error("error fallback:", cause)
        return FALLBACK
    }
}
