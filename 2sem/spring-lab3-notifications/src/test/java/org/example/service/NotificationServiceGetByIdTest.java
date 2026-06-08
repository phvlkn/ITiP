package org.example.service;

import org.example.model.entity.Notification;
import org.example.repository.NotificationRepository;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificationServiceGetByIdTest {
    @Mock
    private NotificationRepository notificationRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private NotificationService notificationService;

    @Test
    void shouldReturnNotificationById() {
        Notification n = new Notification();
        n.setId(5L);
        n.setTitle("Test");
        when(notificationRepository.findById(5L)).thenReturn(Optional.of(n));
        Notification result = notificationService.getNotificationById(5L);
        assertNotNull(result);
        assertEquals(5L, result.getId());
        assertEquals("Test", result.getTitle());
    }
}