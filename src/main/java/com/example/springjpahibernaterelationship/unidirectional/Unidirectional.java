package com.example.springjpahibernaterelationship.uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class Unidirectional {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void performJpaOperations() {
        // create department entity
        DepartmentUD departmentUD = DepartmentUD.builder()
                .name("Human Resources")
                .build();

        // store department
        entityManager.persist(departmentUD);

        // create employee1
        EmployeeUD employeeUD1 = EmployeeUD.builder()
                .name("John Smith")
                .salary(6500.0)
                .designation("Recruitment Specialist")
                .departmentUD(departmentUD)
                .build();

        // create employee2
        EmployeeUD employeeUD2 = EmployeeUD.builder()
                .name("Emily Kim")
                .salary(8500.0)
                .designation("HR Manager")
                .departmentUD(departmentUD)
                .build();

        // create employee3
        EmployeeUD employeeUD3 = EmployeeUD.builder()
                .name("Liam Johnson")
                .salary(8500.0)
                .designation("HR Assistant")
                .departmentUD(departmentUD)
                .build();

        // store employees
        entityManager.persist(employeeUD1);
        entityManager.persist(employeeUD2);
        entityManager.persist(employeeUD3);
    }
}