package com.zoory.texonicinterview.designationservice.service.impl;

import com.zoory.texonicinterview.designationservice.dto.DesignationDTO;
import com.zoory.texonicinterview.designationservice.entity.Designation;
import com.zoory.texonicinterview.designationservice.repo.DesignationRepo;
import com.zoory.texonicinterview.designationservice.service.DesignationService;
import com.zoory.texonicinterview.designationservice.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationServiceImpl implements DesignationService {
    @Autowired
    private DesignationRepo designationRepo;
    @Override
    public void addDesignation(DesignationDTO designationDTO) {
        IdGenerator ids=new IdGenerator();
        String id = ids.generateID();

        if (!designationRepo.existsById(id)){
            Designation designation=new Designation(id,designationDTO.getDesignationName(),designationDTO.getRemarks());
            designationRepo.save(designation);


        }else {
            throw new IllegalArgumentException("Id is already exists");
        }

    }

    @Override
    public List<Designation> getAllDesignation() {
        return designationRepo.findAll();
    }
}
