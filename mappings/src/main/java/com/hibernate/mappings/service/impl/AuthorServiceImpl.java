package com.hibernate.mappings.service.impl;

import com.hibernate.mappings.exception.AuthorNotFoundException;
import com.hibernate.mappings.model.Author;
import com.hibernate.mappings.repository.AuthorRepository;
import com.hibernate.mappings.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        log.info("Fetching all authors from the database.");
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        log.debug("Fetching author by ID: {}", id);
        return authorRepository.findById(id);
    }

    @Override
    public Author createAuthor(Author author) {
        log.info("Creating new author: {}", author);
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author authorDetails) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            author.setName(authorDetails.getName());
            author.setBooks(authorDetails.getBooks());
            return authorRepository.save(author);
        }else {
            log.error("Author with ID {} not found.", id);
            throw new AuthorNotFoundException("Author not found"); // Assuming NotFoundException is a custom exception
        }
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
