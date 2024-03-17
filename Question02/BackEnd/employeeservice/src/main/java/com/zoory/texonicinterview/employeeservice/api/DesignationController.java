package com.zoory.texonicinterview.employeeservice.api;

import com.zoory.texonicinterview.employeeservice.dto.EmployeeDTO;
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
}
