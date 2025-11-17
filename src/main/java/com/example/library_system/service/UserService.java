package com.example.library_system.service;

import com.example.library_system.exception.EmailAlreadyExistsException;
import com.example.library_system.model.User;
import com.example.library_system.model.dto.UserRequestDTO;
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

    public UserResponseDTO addUser(UserRequestDTO dto) {
        if(repository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException(dto.getEmail());
        }

        User saved = repository.save(toEntity(dto));

        return toResponse(saved);
    }

    public User toEntity(UserRequestDTO dto) {
        return new User(
                dto.getName(),
                dto.getEmail()
        );
    }

    public UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
