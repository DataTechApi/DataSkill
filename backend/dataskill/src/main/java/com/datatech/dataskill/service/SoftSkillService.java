package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.model.SoftSkill;
import com.datatech.dataskill.repository.SoftSkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftSkillService {
    private final SoftSkillRepository softSkillRepository;
    public SoftSkillService(SoftSkillRepository softSkillRepository) {
        this.softSkillRepository = softSkillRepository;
    }

    public void cadastrarSoftSkill(SoftSkill softSkill){
        softSkillRepository.save(softSkill);
    }
    public List<SoftSkill> listarSoftSkills(){
        return softSkillRepository.findAll();
    }
}
