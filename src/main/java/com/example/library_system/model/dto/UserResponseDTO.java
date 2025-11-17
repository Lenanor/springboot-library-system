package com.example.library_system.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
