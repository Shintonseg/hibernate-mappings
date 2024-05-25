package com.hibernate.mappings.repository;

import com.hibernate.mappings.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    //JPQL query - on entities and field
    @Query("SELECT a FROM Author a WHERE a.name LIKE %:keyword%")
    List<Author> findAuthorsByNameContaining(String keyword);

    // native query for database and for writing complex queries
    @Query(value = "SELECT * FROM author WHERE name = ?1", nativeQuery = true)
    List<Author> findAuthorsByName(String name);
}
