package com.example.springjpahibernaterelationship.unidirectional.manyToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersistUniMtm {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void performJpaOperations() {
        createTables();
    }

    @Transactional
    public void createTables() {

        // create
        Author author = Author.builder()
                .name("Emily Kim")
                .build();

        // store
        entityManager.persist(author);

        // create
        Author author2 = Author.builder()
                .name("John Smith")
                .build();

        Set<Author> authorsList = new HashSet<>();
        authorsList.add(author);

        Set<Author> authorsList2 = new HashSet<>();
        authorsList2.add(author);
        authorsList2.add(author2);

        // store
        entityManager.persist(author2);

        // create 1
        Book book1 = Book.builder()
                .description("Manager")
                .authors(authorsList)
                .build();

        // create 2
        Book book2 = Book.builder()
                .description("Cooking")
                .authors(authorsList2)
                .build();

        // store
        entityManager.persist(book1);
        entityManager.persist(book2);
    }

    @Transactional
    public void dropTableBeforeCreate() {
        // drop tables if exists
        entityManager.createNativeQuery("DROP TABLE IF EXISTS book_author cascade").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS book cascade").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS author cascade").executeUpdate();
    }

}