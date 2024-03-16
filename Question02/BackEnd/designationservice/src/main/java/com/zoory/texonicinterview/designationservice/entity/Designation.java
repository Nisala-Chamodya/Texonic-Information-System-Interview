package com.zoory.texonicinterview.designationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Designation {
    @Id
    private String dId;
    private String designationName;
    private String remarks;
}
