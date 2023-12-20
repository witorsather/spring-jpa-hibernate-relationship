package com.example.springjpahibernaterelationship.unidirectional.manyToOne;

import com.example.springjpahibernaterelationship.unidirectional.oneToMany.Department;
import com.example.springjpahibernaterelationship.unidirectional.oneToMany.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PersistUniMto {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void performJpaOperations() {
        // create department entity
        Department department = Department.builder()
                .name("Human Resources")
                .build();

        // store department
        entityManager.persist(department);

        // create employee1
        Employee employee1 = Employee.builder()
                .name("John Smith")
                .salary(6500.0)
                .designation("Recruitment Specialist")
                .build();

        // create employee2
        Employee employee2 = Employee.builder()
                .name("Emily Kim")
                .salary(8500.0)
                .designation("HR Manager")
                .build();

        // create employee3
        Employee employee3 = Employee.builder()
                .name("Liam Johnson")
                .salary(8500.0)
                .designation("HR Assistant")
                .build();

        // store employees
        entityManager.persist(employee1);
//        entityManager.persist(employee2);
//        entityManager.persist(employee3);
    }
}