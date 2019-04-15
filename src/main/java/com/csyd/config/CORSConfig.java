package com.csyd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static sun.tools.jconsole.Messages.ALL;

/**
 * Created by ChengShanyunduo
 * axios跨域请求问题
 * 2019/3/25
 */

@Configuration
public class CORSConfig {



        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    // 限制了路径和域名的访问
                    registry.addMapping("/api*").allowedOrigins("http://localhost:8080");
//                    registry.addMapping("/**")
//                            .allowedOrigins(ALL)
//                            .allowedMethods(ALL)
//                            .allowedHeaders(ALL)
//                            .allowCredentials(true);
                }
            };
        }


}
