package com.imooc.spring.cloud.weather.city.service

import com.alicp.jetcache.anno.CachePenetrationProtect
import com.alicp.jetcache.anno.CacheRefresh
import com.alicp.jetcache.anno.CacheType
import com.alicp.jetcache.anno.Cached
import com.imooc.spring.cloud.city.dto.CityDTO

import java.util.concurrent.TimeUnit


/**
 * @author linyicong
 * @since 2019-05-23
 */
interface IWeatherCityService {
    /**
     * 使用本地+远程双层缓存
     * 远程缓存7天失效
     * 本地缓存1天失效
     * 本地缓存元素数量限制为200
     * 刷新缓存周期为1天
     * 刷线缓存保护机制，分布式环境下只有一台会刷新缓存
     *
     * @return
     */
    @Cached(name = "cities", expire = 7, localExpire = 1, timeUnit = TimeUnit.DAYS, localLimit = 200, cacheType = CacheType.BOTH)
    @CacheRefresh(refresh = 5, timeUnit = TimeUnit.SECONDS)
    @CachePenetrationProtect
    List<CityDTO> getAllCityList()
}