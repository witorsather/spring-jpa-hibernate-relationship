package com.example.springjpahibernaterelationship.bidirectional.manyToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class PersistBiMtm {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void performJpaOperations() {
        createTables();
    }

    @Transactional
    public void createTables() {

        // create students
        StudentBiMtm studentBiMtm1 = StudentBiMtm.builder()
                .name("Emily Kim")
                .courses(new ArrayList<>())
                .build();

        StudentBiMtm studentBiMtm2 = StudentBiMtm.builder()
                .name("John Smith")
                .courses(new ArrayList<>())
                .build();

        StudentBiMtm studentBiMtm3 = StudentBiMtm.builder()
                .name("Sarah Connor")
                .courses(new ArrayList<>())
                .build();

        // create courses
        Course course1 = Course.builder()
                .name("Development")
                .students(new ArrayList<>())
                .build();

        Course course2 = Course.builder()
                .name("Managment")
                .students(new ArrayList<>())
                .build();

        // establish relationships
        studentBiMtm1.getCourses().add(course1);
        studentBiMtm1.getCourses().add(course2);

        studentBiMtm2.getCourses().add(course1);

        studentBiMtm3.getCourses().add(course2);

        course1.getStudents().add(studentBiMtm1);
        course1.getStudents().add(studentBiMtm2);

        course2.getStudents().add(studentBiMtm1);
        course2.getStudents().add(studentBiMtm3);

        // store entities
        entityManager.persist(studentBiMtm1);
        entityManager.persist(studentBiMtm2);
        entityManager.persist(studentBiMtm3);
        entityManager.persist(course1);
        entityManager.persist(course2);
    }

    @Transactional
    public void dropTableBeforeCreate() {
        // drop tables if exists
        entityManager.createNativeQuery("DROP TABLE IF EXISTS Course_Student cascade").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS Course cascade").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS Student cascade").executeUpdate();
    }

}