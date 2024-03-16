package com.zoory.texonicinterview.designationservice.api;

import com.zoory.texonicinterview.designationservice.dto.DesignationDTO;
import com.zoory.texonicinterview.designationservice.service.DesignationService;
import com.zoory.texonicinterview.designationservice.util.ResponseUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/designation")
@CrossOrigin
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @PostMapping
    public ResponseUtill addDesignation(@RequestBody DesignationDTO designationDTO){

        designationService.addDesignation(designationDTO);

        return  new ResponseUtill(200,"Designation Saved",null);
    }
}
