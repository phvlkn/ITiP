package org.example.service;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class NotificationManager {
    private final Map<String, MessageService> services;

    public NotificationManager(Map<String, MessageService> services) {
        this.services = services;
    }

    // channels: например "sms,telegram" или "customEmail"
    public void notify(String message, String recipient, String channels) {
        if (channels == null || channels.isBlank()) {
            throw new IllegalArgumentException("channels is empty");
        }

        for (String key : channels.split(",")) {
            String beanName = key.trim();
            MessageService service = services.get(beanName);
            if (service == null) {
                throw new IllegalArgumentException("Unknown channel: " + beanName +
                        ". Available: " + services.keySet());
            }
            service.sendMessage(message, recipient);
        }
    }

    public void notify(String message, String email) {

    }
}