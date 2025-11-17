package com.example.library_system.controller;

import com.example.library_system.model.dto.BookRequestDTO;
import com.example.library_system.model.dto.BookResponseDTO;
import com.example.library_system.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<BookResponseDTO> addBook(@Valid @RequestBody BookRequestDTO dto) {
        return ResponseEntity.ok(service.addBook(dto));
    }
}
