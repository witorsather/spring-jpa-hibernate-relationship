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
public class EmployeeBiOtm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double salary;

    private String designation;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentBiOtm departmentBiOtm;
}
