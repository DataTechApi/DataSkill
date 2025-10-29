package com.datatech.dataskill.entities.dtos.request;

import com.datatech.dataskill.entities.enums.Soft;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor  
public class SoftSkillDTORequest {

    private Soft nome;
}
