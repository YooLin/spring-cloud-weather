package com.imooc.spring.cloud.weather.gateway.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 集成apollo测试
 * @author linyicong* @since 2019-06-07
 */
@RestController
@RequestMapping("/config")
class ApolloConfigController {
    @Value('${test: "测试"}')
    private String testConfigStr

    @GetMapping("/test")
    String getTestConfig() {
        return this.testConfigStr
    }
}
