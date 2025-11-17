package com.example.library_system.controller;

import com.example.library_system.model.User;
import com.example.library_system.model.dto.UserRequestDTO;
import com.example.library_system.model.dto.UserResponseDTO;
import com.example.library_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = service.getAllUsers();

        if(users.isEmpty()) {
           return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(service.getAllUsers());
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto) {

    }
}
