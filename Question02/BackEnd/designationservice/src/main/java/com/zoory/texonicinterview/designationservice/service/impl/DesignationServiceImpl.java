
package com.zoory.texonicinterview.designationservice.service.impl;

import com.zoory.texonicinterview.designationservice.dto.DesignationDTO;
import com.zoory.texonicinterview.designationservice.entity.Designation;
import com.zoory.texonicinterview.designationservice.repo.DesignationRepo;
import com.zoory.texonicinterview.designationservice.service.DesignationService;
import com.zoory.texonicinterview.designationservice.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Designation updateDesignation(String id, Designation designation) {
        Designation designationVar = designationRepo.findById(id).orElse(null); // Using orElse to handle null case
        if (designationRepo.existsById(id)) {
            designationVar.setDesignationName(designation.getDesignationName());
            designationVar.setRemarks(designation.getRemarks());
            designationRepo.save(designationVar);
            return designationVar;
        } else {
            throw new IllegalArgumentException("Designation with id " + id + " not found");
        }
    }

    @Override
    public Designation deleteDesignation(String id) {
        Optional<Designation> optionalDesignation = designationRepo.findById(id);
        if (designationRepo.existsById(id)) {
            Designation designation = optionalDesignation.get();
            designationRepo.deleteById(id);
            return designation;
        } else {
            throw new IllegalArgumentException("Designation with id " + id + " not found");
        }
    }

}
