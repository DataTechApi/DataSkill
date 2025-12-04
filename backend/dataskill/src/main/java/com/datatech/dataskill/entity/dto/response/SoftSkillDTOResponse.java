package com.datatech.dataskill.entity.dto.response;

import com.datatech.dataskill.entity.model.SoftSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoftSkillDTOResponse{
    private String name;
    private Long value;
}
