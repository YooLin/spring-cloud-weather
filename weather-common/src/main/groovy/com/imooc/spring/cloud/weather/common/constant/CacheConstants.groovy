package com.imooc.spring.cloud.weather.common.constant

/**
 * @author linyicong* @since 2019-05-19
 */
interface CacheConstants {
    // 城市天气缓存Key
    String CITY_WEATHER_KEY = "city_weather"

    // 默认缓存超时时间，单位：分钟
    int DEFAULT_CACHE_TTL_MINUTE = 5
}