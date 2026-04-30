package org.example.service;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.model.dto.NotificationDto;
import org.example.model.entity.Notification;
import org.example.model.entity.User;
import org.example.model.enums.NotificationChannel;
import org.example.model.enums.NotificationStatus;
import org.example.repository.NotificationRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Transactional
    public Notification createNotification(NotificationDto request) {
        User user = userRepository.findById(request.getRecipientId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + request.getRecipientId()));
        Notification notification = new Notification();
        notification.setTitle(request.getTitle());
        notification.setMessage(request.getMessage());
        notification.setChannel(request.getChannel());
        notification.setStatus(NotificationStatus.CREATED);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRecipient(user);
        notificationRepository.save(notification);
        /* if (true) {
            throw new RuntimeException("Искусственная ошибка");
        }

         */
        return notification;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElseThrow();
    }

    public Notification updateNotification(Long id, NotificationDto request) {
        Notification notification = notificationRepository.findById(id).orElseThrow();

        notification.setTitle(request.getTitle());
        notification.setMessage(request.getMessage());
        notification.setChannel(request.getChannel());

        if (request.getStatus() != null) {
            notification.setStatus(request.getStatus());

            if (request.getStatus() == NotificationStatus.SENT && notification.getSentAt() == null) {
                notification.setSentAt(LocalDateTime.now());
            }
        }

        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow();
        notificationRepository.delete(notification);
    }

    public List<Notification> getNotificationsByStatus(NotificationStatus status) {
        return notificationRepository.findByStatus(status);
    }

    public List<Notification> getNotificationsByChannel(NotificationChannel channel) {
        return notificationRepository.findByChannel(channel);
    }

    public List<Notification> getNotificationsByRecipientId(Long recipientId) {
        return notificationRepository.findByRecipientId(recipientId);
    }
}
