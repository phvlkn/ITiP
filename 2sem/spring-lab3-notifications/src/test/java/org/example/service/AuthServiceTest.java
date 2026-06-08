package org.example.service;

import org.example.model.dto.RegisterRequest;
import org.example.model.entity.User;
import org.example.model.enums.UserRole;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    @Test
    void registerShouldSaveUserWithEncodedPasswordAndUserRole() {
        RegisterRequest req = new RegisterRequest();
        req.setName("Emin");
        req.setEmail("emin@test.com");
        req.setPassword("123456");

        when(userRepository.existsByEmail("emin@test.com")).thenReturn(false);
        when(passwordEncoder.encode("123456")).thenReturn("bcrypt_hash");

        authService.register(req);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(captor.capture());

        User saved = captor.getValue();
        assertEquals("Emin", saved.getName());
        assertEquals("emin@test.com", saved.getEmail());
        assertEquals("bcrypt_hash", saved.getPassword());
        assertEquals(UserRole.ROLE_USER, saved.getRole());
        assertNotNull(saved.getCreatedAt());

        verify(passwordEncoder, times(1)).encode("123456");
        verify(userRepository, times(1)).existsByEmail("emin@test.com");
    }

    @Test
    void registerShouldThrowConflictWhenEmailExists() {
        RegisterRequest req = new RegisterRequest();
        req.setName("Emin");
        req.setEmail("emin@test.com");
        req.setPassword("123456");

        when(userRepository.existsByEmail("emin@test.com")).thenReturn(true);

        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> authService.register(req));

        assertEquals(HttpStatus.CONFLICT, ex.getStatusCode());
        assertEquals("Email already exists", ex.getReason());

        verify(userRepository, times(1)).existsByEmail("emin@test.com");
        verify(userRepository, never()).save(any(User.class));
        verify(passwordEncoder, never()).encode(anyString());
    }

    @Test
    void registerAdminShouldSaveUserWithAdminRole() {
        RegisterRequest req = new RegisterRequest();
        req.setName("Admin");
        req.setEmail("admin@test.com");
        req.setPassword("adminpass");

        when(userRepository.existsByEmail("admin@test.com")).thenReturn(false);
        when(passwordEncoder.encode("adminpass")).thenReturn("bcrypt_admin");

        authService.registerAdmin(req);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(captor.capture());

        User saved = captor.getValue();
        assertEquals("Admin", saved.getName());
        assertEquals("admin@test.com", saved.getEmail());
        assertEquals("bcrypt_admin", saved.getPassword());
        assertEquals(UserRole.ROLE_ADMIN, saved.getRole());
        assertNotNull(saved.getCreatedAt());

        verify(passwordEncoder, times(1)).encode("adminpass");
        verify(userRepository, times(1)).existsByEmail("admin@test.com");
    }
}