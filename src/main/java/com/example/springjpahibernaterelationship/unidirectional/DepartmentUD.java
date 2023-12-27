package com.example.springjpahibernaterelationship.uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class DepartmentUD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public DepartmentUD(int id, String name) {
        this.name = name;
    }

    public DepartmentUD() {
        
    }
}
