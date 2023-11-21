package com.easycar.image.config;

import com.easycar.common.config.ResourceServerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ResourceServerConfig.class})
public class WebConfig {
}
