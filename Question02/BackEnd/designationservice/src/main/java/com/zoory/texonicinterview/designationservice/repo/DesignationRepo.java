package com.zoory.texonicinterview.designationservice.repo;

import com.zoory.texonicinterview.designationservice.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepo extends JpaRepository<Designation,String>{
}
