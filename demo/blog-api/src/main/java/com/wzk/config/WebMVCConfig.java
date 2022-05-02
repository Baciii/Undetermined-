package com.wzk.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wzk
 * @date 2022/5/1 20:53
 */
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        //跨域配置
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }

}
