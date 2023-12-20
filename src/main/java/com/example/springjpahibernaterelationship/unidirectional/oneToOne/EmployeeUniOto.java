package com.example.springjpahibernaterelationship.unidirectional.oneToOne;

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
public class EmployeeUniOto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name = "parking_spot_id")
    ParkingSpot parkingSpot;
}
