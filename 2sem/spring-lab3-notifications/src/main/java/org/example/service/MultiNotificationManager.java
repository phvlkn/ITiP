package org.example.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiNotificationManager {
    private final List<MessageService> services;

    public MultiNotificationManager(List<MessageService> services) {
        this.services = services; // тут будут ВСЕ сервисы
    }
}