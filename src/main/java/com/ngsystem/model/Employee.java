package com.ngsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Employee {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmploye;
    @Column(length = 100,nullable = false)
    private String name;
    @Column(length = 10,nullable = false)
    private String phone;
    @Column(length = 50,nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDateTime joindate;
}
