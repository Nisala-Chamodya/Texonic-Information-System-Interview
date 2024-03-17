package com.zoory.texonicinterview.employeeservice.service.impl;

import com.zoory.texonicinterview.employeeservice.dto.EmployeeDTO;
import com.zoory.texonicinterview.employeeservice.entity.Employee;
import com.zoory.texonicinterview.employeeservice.repo.EmployeeRepo;
import com.zoory.texonicinterview.employeeservice.service.EmployeeService;
import com.zoory.texonicinterview.employeeservice.utill.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        IdGenerator ids=new IdGenerator();
        String id = ids.generateID();

        if (!employeeRepo.existsById(id)){
            Employee employee=new Employee(id,employeeDTO.getFullName(),employeeDTO.getDesignation(),employeeDTO.getDateOfJoin(),employeeDTO.getIsManager());
            employeeRepo.save(employee);


        }else {
            throw new IllegalArgumentException("Id is already exists");
        }
    }
}
