package org.example.config;

import org.example.service.SmsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AnotherConfig {

    @Bean
    @Primary
    public SmsService smsService() {
        return new SmsService();
    }
}