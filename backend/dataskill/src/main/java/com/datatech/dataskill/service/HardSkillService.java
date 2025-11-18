package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.dto.request.HardSkillDTORequest;
import com.datatech.dataskill.entity.model.HardSkill;
import com.datatech.dataskill.repository.HardSkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardSkillService {

    private final HardSkillRepository hardSkillRepository;

    public HardSkillService(HardSkillRepository hardSkillRepository) {
        this.hardSkillRepository = hardSkillRepository;
    }

    public void cadastrarHardSkill(HardSkill hardSkill){
        hardSkillRepository.save(hardSkill);
    }
    public List<HardSkill> listarHardSkills(Long userId){
        return hardSkillRepository.findHardSkills(userId);
    }
}
