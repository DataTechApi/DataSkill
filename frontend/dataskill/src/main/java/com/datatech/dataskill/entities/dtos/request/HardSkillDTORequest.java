package com.datatech.dataskill.entities.dtos.request;

import com.datatech.dataskill.entities.enums.Hard;
import com.datatech.dataskill.entities.enums.Soft;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor  
public class HardSkillDTORequest {
    private Hard nome;
}
