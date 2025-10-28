package com.datatech.dataskill.entity.dto.request;

import com.datatech.dataskill.entity.enums.Hard;
import com.datatech.dataskill.entity.enums.Nivel;
import com.datatech.dataskill.entity.model.HardSkill;

import java.util.List;

public record HardSkillDTORequest(
        Hard nome,
        Nivel nivel
) {}
