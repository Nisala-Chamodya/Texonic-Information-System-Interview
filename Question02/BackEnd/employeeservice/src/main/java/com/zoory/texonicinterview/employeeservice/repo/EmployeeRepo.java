package com.zoory.texonicinterview.employeeservice.repo;

import com.zoory.texonicinterview.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,String> {
}
