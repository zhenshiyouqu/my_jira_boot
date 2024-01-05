package org.example.my_jira_boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")//允许跨域的域名，可以用*表示允许任何域名使用
                .allowCredentials(true)//允许客户端发送cookie
                .allowedMethods("GET", "POST", "DELETE", "PUT")//允许的请求方法
                .maxAge(3600);//预检间隔时间
    }
}
