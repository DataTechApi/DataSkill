package com.datatech.dataskill.entity.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardSkillDTOResponse{
    private Long id;
    private String nome;
    private String nivel;
}
