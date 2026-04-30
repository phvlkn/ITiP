package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class SingleNotificationManager {
    private final MessageService messageService;

    public SingleNotificationManager(MessageService messageService) {
        this.messageService = messageService; // тут сработает @Primary
    }
}