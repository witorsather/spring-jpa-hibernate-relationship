package com.example.springjpahibernaterelationship.uni;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

@Entity
@Builder
public class EmployeeUD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private double salary;

    private String designation;

    @ManyToOne
    private DepartmentUD departmentUD;

    public EmployeeUD() {
    }

    public EmployeeUD(int id, String name, double salary, String designation, DepartmentUD departmentUD) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.departmentUD = departmentUD;
    }
}
