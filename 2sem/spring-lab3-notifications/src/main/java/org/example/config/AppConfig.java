package org.example.config;

import org.example.service.EmailService;
import org.example.service.PushService;
import org.example.service.SmsService;
import org.example.service.NotificationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

}