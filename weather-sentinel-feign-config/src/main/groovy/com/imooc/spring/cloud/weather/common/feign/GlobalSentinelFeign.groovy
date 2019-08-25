package com.imooc.spring.cloud.weather.common.feign

import feign.Contract
import feign.Feign
import feign.InvocationHandlerFactory
import feign.Target
import feign.hystrix.FallbackFactory
import org.springframework.beans.BeansException
import org.springframework.cloud.alibaba.sentinel.feign.SentinelContractHolder
import org.springframework.cloud.alibaba.sentinel.feign.SentinelInvocationHandler
import org.springframework.cloud.openfeign.FeignContext
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.util.ReflectionUtils

import java.lang.reflect.Field
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 * @author linyicong* @since 2019-08-24
 */
class GlobalSentinelFeign {

    static Builder builder() {
        return new Builder()
    }

    static final class Builder extends Feign.Builder implements ApplicationContextAware {
        private Contract contract = new Contract.Default()
        private ApplicationContext applicationContext
        private FeignContext feignContext

        @Override
        Feign.Builder invocationHandlerFactory(InvocationHandlerFactory invocationHandlerFactory) {
            throw new UnsupportedOperationException()
        }

        @Override
        Builder contract(Contract contract) {
            this.contract = contract
            return this
        }

        @Override
        Feign build() {
            super.invocationHandlerFactory(new InvocationHandlerFactory() {
                @Override
                InvocationHandler create(Target target, Map<Method, InvocationHandlerFactory.MethodHandler> dispatch) {
                    Object feignClientFactoryBean = Builder.this.applicationContext.getBean("&" + target.type().getName())

                    Class fallback = getFieldValue(feignClientFactoryBean, "fallback") as Class
                    Class fallbackFactory = getFieldValue(feignClientFactoryBean, "fallbackFactory") as Class
                    String name = getFieldValue(feignClientFactoryBean, "name") as String

                    Object fallbackInstance
                    FallbackFactory fallbackFactoryInstance
                    // check fallback and fallbackFactory properties
                    if (void.class != fallback) {
                        fallbackInstance = getFromContext(name, "fallback", fallback, target.type())
                        return new SentinelInvocationHandler(target, dispatch, new FallbackFactory.Default(fallbackInstance))
                    }
                    if (void.class != fallbackFactory) {
                        fallbackFactoryInstance = (FallbackFactory) getFromContext(name, "fallbackFactory", fallbackFactory, FallbackFactory.class)
                        return new SentinelInvocationHandler(target, dispatch, fallbackFactoryInstance)
                    }
                    // 默认的 fallbackFactory
                    GlobalSentinelFeignFallbackFactory funFallbackFactory = new GlobalSentinelFeignFallbackFactory(target)
                    return new SentinelInvocationHandler(target, dispatch, funFallbackFactory)
                }

                private Object getFromContext(String name, String type, Class fallbackType, Class targetType) {
                    Object fallbackInstance = feignContext.getInstance(name, fallbackType)
                    if (fallbackInstance == null) {
                        throw new IllegalStateException(String.format("No %s instance of type %s found for feign client %s", type, fallbackType, name))
                    }

                    if (!targetType.isAssignableFrom(fallbackType)) {
                        throw new IllegalStateException(String.format("Incompatible %s instance. Fallback/fallbackFactory of type %s is not assignable to %s for feign client %s", type, fallbackType, targetType, name))
                    }
                    return fallbackInstance
                }
            })
            super.contract(new SentinelContractHolder(contract))
            return super.build()
        }

        private Object getFieldValue(Object instance, String fieldName) {
            Field field = ReflectionUtils.findField(instance.getClass(), fieldName)
            field.setAccessible(true)
            try {
                return field.get(instance)
            } catch (IllegalAccessException e) {
                // ignore
            }
            return null
        }

        @Override
        void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext
            feignContext = this.applicationContext.getBean(FeignContext.class)
        }
    }
}
