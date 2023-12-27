package com.example.springjpahibernaterelationship.bidirectional.oneToMany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double salary;

    private String designation;

    @ManyToOne
    private DepartmentBiOtm departmentBiOtm;
}
