package com.sea.weed.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/config/globalConfig.properties")
public class GlobalProperties {

    @Value("${host}")
    public String HOST;
}
