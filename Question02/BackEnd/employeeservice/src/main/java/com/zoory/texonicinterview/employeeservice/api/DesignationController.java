package com.zoory.texonicinterview.employeeservice.api;

import com.zoory.texonicinterview.employeeservice.dto.EmployeeDTO;
import com.zoory.texonicinterview.employeeservice.entity.Employee;
import com.zoory.texonicinterview.employeeservice.service.EmployeeService;
import com.zoory.texonicinterview.employeeservice.utill.ResponseUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin
public class DesignationController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseUtill addEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.addEmployee(employeeDTO);
        return new ResponseUtill(200,"Employee Saved",null);
    }
    @GetMapping
    public  ResponseUtill getAllEmployee(){
        return new ResponseUtill(200,"Get All Employee",employeeService.getAllEmployee());
    }
    @PutMapping("/{id}")
    public ResponseUtill updateEmployee(@PathVariable String id, @RequestBody Employee employee){
        Employee employee1=employeeService.updateEmployee(id,employee);
        return new ResponseUtill(200,"Update Success",employee1);
    }
    @DeleteMapping("/{id}")
    public ResponseUtill deleteEmployee(@PathVariable String id){
        Employee employee=employeeService.deleteEmployee(id);
        return new ResponseUtill(200,"Delete Employee",employee);
    }
}
