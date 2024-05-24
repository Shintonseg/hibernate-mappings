package com.hibernate.mappings.service;

import com.hibernate.mappings.model.Book;
import com.hibernate.mappings.model.dto.BookRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    Book createBook(BookRequest book);
    Book updateBook(Long id, Book bookDetails);
    void deleteBook(Long id);
}
