package com.dmsb.employeesapi.model;

import com.dmsb.employeesapi.enums.CompanyPosition;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "company_position", nullable = false)
    private CompanyPosition companyPosition;

    @Column(nullable = false)
    private int age;

    @Column(name = "company_years", nullable = false)
    private int companyYears;

    @Column(nullable = false)
    private double salary;

}
