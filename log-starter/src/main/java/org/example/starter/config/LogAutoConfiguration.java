package org.example.starter.config;

import org.example.starter.config.org.example.starter.HttpLoggingAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LogProperties.class)
@ConditionalOnProperty(prefix = "logging.http", name = "enable", havingValue = "true", matchIfMissing = true)
public class LogAutoConfiguration {
    @Bean
    public HttpLoggingAspect httpLoggingAspect(LogProperties properties) {
        return new HttpLoggingAspect(properties);
    }

}
