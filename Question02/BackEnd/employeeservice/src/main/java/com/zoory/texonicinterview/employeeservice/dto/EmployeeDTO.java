package com.zoory.texonicinterview.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EmployeeDTO {
    private String fullName;
    private String designation;
    private String dateOfJoin;
    private String isManager;
}
