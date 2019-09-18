package com.wr.mypracticespringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangru
 * @create 2019-09-07 9:01
 */
@Configuration
public class CORSCfiguration implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //对那种格式进行跨域处理
        registry.addMapping("/**")
                //允许的请求域
                .allowedOrigins("http://localhost:8083")
                //允许的请求方法
                .allowedMethods("*")
                //允许的请求头
                .allowedHeaders("*");
        //探测请求的有效期
        /*.maxAge(1800);*/
    }
}