package com.hibernate.mappings.service;

import com.hibernate.mappings.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();
    Optional<Author> getAuthorById(Long id);
    Author createAuthor(Author author);
    Author updateAuthor(Long id, Author authorDetails);
    void deleteAuthor(Long id);
}
