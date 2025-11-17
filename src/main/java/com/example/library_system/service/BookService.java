package com.example.library_system.service;

import com.example.library_system.model.Book;
import com.example.library_system.model.dto.BookRequestDTO;
import com.example.library_system.model.dto.BookResponseDTO;
import com.example.library_system.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookResponseDTO addBook(BookRequestDTO dto) {
        Book book = toEntity(dto);
        Book saved = repository.save(book);

        return toResponse(saved);
    }

    public Book toEntity(BookRequestDTO dto) {
        return new Book(
                dto.getTitle(),
                dto.getAuthor(),
                dto.getIsbn(),
                dto.getGenre()
        );
    }

    public BookResponseDTO toResponse(Book book) {
        return new BookResponseDTO(
             book.getId(),
             book.getTitle(),
             book.getAuthor(),
             book.getIsbn(),
             book.getGenre()
        );
    }
}
