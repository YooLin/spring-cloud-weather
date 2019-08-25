package com.imooc.spring.cloud.gateway.fallback


import com.imooc.spring.cloud.gateway.client.WeatherGatewayClient
import feign.hystrix.FallbackFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @author linyicong* @since 2019-05-19
 */
@Component
class WeatherGatewayClientFallbackFactory implements FallbackFactory<WeatherGatewayClient> {
    private static final Logger logger = LoggerFactory.getLogger(WeatherGatewayClientFallbackFactory)

    @Override
    WeatherGatewayClient create(Throwable cause) {
        logger.error("customer fallback error :", cause)
        return new WeatherGatewayClientFallback()
    }
}
