package com.imooc.spring.cloud.weather.collection.client.fallback

import com.imooc.spring.cloud.weather.collection.client.WeatherDataOpenClient
import feign.hystrix.FallbackFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @author linyicong* @since 2019-05-19
 */
@Component
class WeatherDataOpenClientFallbackFactory implements FallbackFactory<WeatherDataOpenClient> {
    private static final WeatherDataOpenClientFallback FALLBACK = new WeatherDataOpenClientFallback()
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataOpenClientFallback)

    @Override
    WeatherDataOpenClient create(Throwable cause) {
        logger.error("error fallback:", cause)
        return FALLBACK
    }
}
