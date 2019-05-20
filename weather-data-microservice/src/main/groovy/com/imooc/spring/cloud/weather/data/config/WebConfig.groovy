package com.imooc.spring.cloud.weather.data.config

import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

/**
 * @author linyicong* @since 2019-05-19
 */
@Configuration
class WebConfig {
    /**
     * 新增自定义HTTP消息转换器
     * @return
     */
    @Bean
    HttpMessageConverters customConverters() {
        HttpMessageConverter octetStreamJacksonConverter = this.jacksonSupportsMoreTypes()
        return new HttpMessageConverters(octetStreamJacksonConverter)
    }

    /**
     * 解决天气开放接口返回content-type: application/octet-stream 的数据时，无法直接用JSON解析成DTO的问题
     * @return
     */
    private HttpMessageConverter jacksonSupportsMoreTypes() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter()
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM))
        return converter
    }
}
