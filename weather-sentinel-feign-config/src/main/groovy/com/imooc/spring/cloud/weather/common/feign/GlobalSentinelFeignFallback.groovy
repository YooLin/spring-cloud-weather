package com.imooc.spring.cloud.weather.common.feign

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cglib.proxy.MethodInterceptor
import org.springframework.cglib.proxy.MethodProxy

import java.lang.reflect.Method

/**
 * @author linyicong* @since 2019-08-24
 */
class GlobalSentinelFeignFallback<T> implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalSentinelFeignFallback)

    private final Class<T> targetType
    private final String targetName
    private final Throwable cause

    GlobalSentinelFeignFallback(Class<T> targetType, String targetName, Throwable cause) {
        this.targetType = targetType
        this.targetName = targetName
        this.cause = cause
    }

    @Override
    Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 统一输出异常信息
        LOGGER.error("GlobalSentinelFeignFallback——[{}#{}] serviceName:[{}] has an error!", targetType.getName(), method.getName(), targetName, cause)
        return null
    }
}
