package com.example.ezports.global.config;

import com.example.ezports.global.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({
        JwtProperties.class,
})
@Configuration
public class ConfigurationPropertiesConfig {}
