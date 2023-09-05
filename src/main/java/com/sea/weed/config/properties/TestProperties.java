package com.sea.weed.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/config/testConfig.properties")
public class TestProperties {

    @Value("${mode}")
    public String test;
}
