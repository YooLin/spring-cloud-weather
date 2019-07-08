package com.imooc.spring.cloud.data.fallback

import com.imooc.spring.cloud.data.client.WeatherDataClient
import feign.hystrix.FallbackFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @author linyicong* @since 2019-05-19
 */
@Component
class WeatherDataClientFallbackFactory implements FallbackFactory<WeatherDataClient> {
    private static final WeatherDataClientFallback FALLBACK = new WeatherDataClientFallback()
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataClientFallbackFactory)

    @Override
    WeatherDataClient create(Throwable cause) {
        logger.error("error fallback:", cause)
        return FALLBACK
    }
}
