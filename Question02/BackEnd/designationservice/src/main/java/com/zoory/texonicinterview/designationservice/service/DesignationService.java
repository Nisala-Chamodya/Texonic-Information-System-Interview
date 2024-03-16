package com.zoory.texonicinterview.designationservice.service;

import com.zoory.texonicinterview.designationservice.dto.DesignationDTO;
import com.zoory.texonicinterview.designationservice.entity.Designation;

import java.util.List;

public interface DesignationService {
    public void addDesignation(DesignationDTO designationDTO);
    List<Designation> getAllDesignation();
    Designation updateDesignation(String id,Designation designation);
}
