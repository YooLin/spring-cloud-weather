package com.imooc.spring.cloud.weather.collection.config

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.ImmutableMap
import com.imooc.spring.cloud.weather.collection.constant.CacheConstants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

import java.time.Duration

/**
 * @author linyicong* @since 2019-05-19
 */
@Configuration
class RedisConfig {
    @Bean
    CacheManager cacheManager(@Autowired RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(buildRedisCacheConfiguration(CacheConstants.DEFAULT_CACHE_TTL_MINUTE))
                .withInitialCacheConfigurations(buildInitialCacheConfigurationMap())
                .transactionAware()
                .build()
    }

    private RedisCacheConfiguration buildRedisCacheConfiguration(int minutes) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object)

        //解决查询缓存转换异常的问题
        ObjectMapper objectMapper = new ObjectMapper()
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper)

        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(minutes))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
    }

    private Map<String, RedisCacheConfiguration> buildInitialCacheConfigurationMap() {
        return ImmutableMap.<String, RedisCacheConfiguration> builder()
                .put(CacheConstants.CITY_WEATHER_KEY, this.buildRedisCacheConfiguration(30))
                .build()
    }
}
