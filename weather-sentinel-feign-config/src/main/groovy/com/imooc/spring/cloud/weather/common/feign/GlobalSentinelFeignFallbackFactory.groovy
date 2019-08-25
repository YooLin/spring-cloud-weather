package com.imooc.spring.cloud.weather.common.feign

import feign.Target
import feign.hystrix.FallbackFactory
import org.springframework.cglib.proxy.Enhancer

/**
 * @author linyicong* @since 2019-08-24
 */
class GlobalSentinelFeignFallbackFactory<T> implements FallbackFactory<T> {
    private final Target<T> target

    GlobalSentinelFeignFallbackFactory(Target<T> target) {
        this.target = target
    }

    @Override
    T create(Throwable cause) {
        final Class<T> targetType = target.type()
        final String targetName = target.name()
        // 动态代理
        Enhancer enhancer = new Enhancer()
        enhancer.setSuperclass(targetType)
        enhancer.setUseCache(true)
        enhancer.setCallback(new GlobalSentinelFeignFallback<>(targetType, targetName, cause))
        return enhancer.create() as T
    }
}
