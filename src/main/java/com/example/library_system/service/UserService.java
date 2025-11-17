package com.example.library_system.service;

import com.example.library_system.model.User;
import com.example.library_system.model.dto.UserResponseDTO;
import com.example.library_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> users = repository.findAll();

        return users.stream()
                .map(this::toResponse)
                .toList();
    }

    public UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
