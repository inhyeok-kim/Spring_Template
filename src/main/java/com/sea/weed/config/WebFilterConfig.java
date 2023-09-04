package com.sea.weed.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sea.weed.filter.TestFilter;

@Configuration
public class WebFilterConfig {

    @Bean
    public FilterRegistrationBean<TestFilter> secondFilter(){
        FilterRegistrationBean<TestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TestFilter());
        registrationBean.addUrlPatterns("*");
        // registrationBean.setOrder(1);
        registrationBean.setName("test-filter");
        return registrationBean;
    }
    
}
