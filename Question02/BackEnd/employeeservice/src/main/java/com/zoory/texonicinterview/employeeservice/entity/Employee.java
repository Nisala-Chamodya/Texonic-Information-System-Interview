package com.zoory.texonicinterview.employeeservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Employee {
    @Id
    private String emId;
    private String fullName;
    private String designation;
    private String dateOfJoin;
    private String isManager;
}
