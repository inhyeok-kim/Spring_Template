package com.sea.weed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Value("${run.type}")
    private String runType;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("LOG :: WebConfig : RUN.TYPE = " + runType);
        if(runType.equals("dev")){
            registry.addMapping("/**")
                .allowedOrigins("*");
        }
        
    }
}
