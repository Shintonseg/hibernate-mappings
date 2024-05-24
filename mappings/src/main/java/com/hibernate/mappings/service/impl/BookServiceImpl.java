package com.hibernate.mappings.service.impl;

import com.hibernate.mappings.model.Author;
import com.hibernate.mappings.model.Book;
import com.hibernate.mappings.model.dto.BookRequest;
import com.hibernate.mappings.repository.AuthorRepository;
import com.hibernate.mappings.repository.BookRepository;
import com.hibernate.mappings.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(BookRequest bookRequest) {
        Optional<Author> authorOptional = authorRepository.findById(bookRequest.getAuthorId());
        if (authorOptional.isPresent()) {
            Book book = new Book();
            book.setTitle(bookRequest.getTitle());
            book.setAuthor(authorOptional.get());
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            return bookRepository.save(book);
        }
        return null; // or throw an exception
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
