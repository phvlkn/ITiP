package org.example.service;

import java.util.List;
import org.example.model.dto.*;
import org.example.model.entity.*;
import lombok.RequiredArgsConstructor;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserDto request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setDeviceToken(request.getDeviceToken());
        user.setTelegramChatId(request.getTelegramChatId());
        user.setCreatedAt(request.getCreatedAt());
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByID(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User updateUser(Long id, UserDto request){
        User user = userRepository.findById(id).orElseThrow();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setDeviceToken(request.getDeviceToken());
        user.setTelegramChatId(request.getTelegramChatId());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}
