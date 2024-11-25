package com.lixd.messagewell.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * 解决资源跨域问题
 */
@Configuration
class CorsConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.run {
            addMapping("/**")// 所有接口
                .allowCredentials(true) // 是否发送 Cookie
                .allowedOriginPatterns("*") // 支持域
                .allowedMethods(*arrayOf("GET", "POST", "PUT", "DELETE")) // 支持方法
                .allowedHeaders("*")
                .exposedHeaders("*");
        }
    }
}