package com.example.springjpahibernaterelationship.unidirectional.oneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PersistUniOto {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void performJpaOperations() {
        
        // create
        ParkingSpot parkingSpot = ParkingSpot.builder()
                .name("AD456")
                .build();

        // store
        entityManager.persist(parkingSpot);

        // create
        ParkingSpot parkingSpot2 = ParkingSpot.builder()
                .name("ZDF897")
                .build();

        // store
        entityManager.persist(parkingSpot2);

        // create 1
        EmployeeUniOto employeeUniOto1 = EmployeeUniOto.builder()
                .name("Emily Kim")
                .parkingSpot(parkingSpot)
                .build();

        // create 2
        EmployeeUniOto employeeUniOto2 = EmployeeUniOto.builder()
                .name("John Smith")
                .parkingSpot(parkingSpot2)
                .build();

        // store
        entityManager.persist(employeeUniOto1);
        entityManager.persist(employeeUniOto2);
    }

    @Transactional
    public void dropTableBeforeCreate() {
        // drop tables if exists
        entityManager.createNativeQuery("DROP TABLE IF EXISTS employee_uni_oto").executeUpdate();
        entityManager.createNativeQuery("DROP TABLE IF EXISTS parking_spot").executeUpdate();
    }
}