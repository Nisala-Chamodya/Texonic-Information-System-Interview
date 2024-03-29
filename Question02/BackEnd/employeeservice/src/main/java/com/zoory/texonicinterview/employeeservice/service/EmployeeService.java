package com.zoory.texonicinterview.employeeservice.service;

import com.zoory.texonicinterview.employeeservice.dto.EmployeeDTO;
import com.zoory.texonicinterview.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(EmployeeDTO employeeDTO);
    List<Employee> getAllEmployee();
    Employee updateEmployee(String id,Employee employee);

    public  Employee deleteEmployee(String id);



}
