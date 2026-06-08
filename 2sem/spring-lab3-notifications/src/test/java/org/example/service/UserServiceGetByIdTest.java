package org.example.service;

import org.example.model.entity.User;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceGetByIdTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserById() {
        User user = new User();
        user.setId(1L);
        user.setEmail("ivan@test.com");
        user.setName("Иван");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserByID(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("ivan@test.com", result.getEmail());
    }
}