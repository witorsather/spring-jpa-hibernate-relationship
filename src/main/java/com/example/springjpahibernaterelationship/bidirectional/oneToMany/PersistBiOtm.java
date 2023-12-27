package com.example.springjpahibernaterelationship.bidirectional.oneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PersistBiOtm {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void performJpaOperations() {
        // create department entity
        DepartmentBiOtm departmentBiOtm = DepartmentBiOtm.builder()
                .name("Human Resources")
                .build();

        // store department
        entityManager.persist(departmentBiOtm);

        // create department entity
        DepartmentBiOtm departmentBiOtm2 = DepartmentBiOtm.builder()
                .name("Development")
                .build();

        // store department
        entityManager.persist(departmentBiOtm2);

        // create employee1
        EmployeeBiOtm employeeBiOtm1 = EmployeeBiOtm.builder()
                .name("John Smith")
                .salary(6500.0)
                .designation("Recruitment Specialist")
                .departmentBiOtm(departmentBiOtm)
                .build();

        // create employee2
        EmployeeBiOtm employeeBiOtm2 = EmployeeBiOtm.builder()
                .name("Emily Kim")
                .salary(8500.0)
                .designation("HR Manager")
                .departmentBiOtm(departmentBiOtm)
                .build();

        // create employee3
        EmployeeBiOtm employeeBiOtm3 = EmployeeBiOtm.builder()
                .name("Liam Johnson")
                .salary(7500.0)
                .designation("Developer")
                .departmentBiOtm(departmentBiOtm2)
                .build();

        // store employees
        entityManager.persist(employeeBiOtm1);
        entityManager.persist(employeeBiOtm2);
        entityManager.persist(employeeBiOtm3);
    }
}