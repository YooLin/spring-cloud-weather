package com.imooc.spring.cloud.weather.collection.client.fallback

import com.imooc.spring.cloud.weather.collection.client.WeatherOpenClient
import feign.hystrix.FallbackFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @author linyicong* @since 2019-05-19
 */
@Component
class WeatherOpenClientFallbackFactory implements FallbackFactory<WeatherOpenClient> {
    private static final WeatherOpenClientFallback FALLBACK = new WeatherOpenClientFallback()
    private static final Logger logger = LoggerFactory.getLogger(WeatherOpenClientFallback)

    @Override
    WeatherOpenClient create(Throwable cause) {
        logger.error("error fallback:", cause)
        return FALLBACK
    }
}
