package com.zoory.texonicinterview.employeeservice.service.impl;

import com.zoory.texonicinterview.employeeservice.dto.EmployeeDTO;
import com.zoory.texonicinterview.employeeservice.entity.Employee;
import com.zoory.texonicinterview.employeeservice.repo.EmployeeRepo;
import com.zoory.texonicinterview.employeeservice.service.EmployeeService;
import com.zoory.texonicinterview.employeeservice.utill.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
       Employee employeevar =employeeRepo.findById(id).orElse(null);;
       if (employeeRepo.existsById(id)){
           employeevar.setFullName(employee.getFullName());
           employeevar.setDesignation(employee.getDesignation());
           employeevar.setDateOfJoin(employee.getDateOfJoin());
           employeevar.setIsManager(employee.getIsManager());
           employeeRepo.save(employeevar);
           return employeevar;
        }else {
           throw new IllegalArgumentException("Designation with id " + id + " not found");
       }
    }

    @Override
    public Employee deleteEmployee(String id) {
        Optional<Employee> optionalDesignation = employeeRepo.findById(id);
        if (employeeRepo.existsById(id)) {
            Employee employee = optionalDesignation.get();
            employeeRepo.deleteById(id);
            return employee;
        } else {
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }
    }
}
