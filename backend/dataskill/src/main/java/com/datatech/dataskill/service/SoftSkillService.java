package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.dto.response.SoftSkillDTOResponse;
import com.datatech.dataskill.entity.model.SoftSkill;
import com.datatech.dataskill.repository.SoftSkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftSkillService {
    private final SoftSkillRepository softSkillRepository;
    public SoftSkillService(SoftSkillRepository softSkillRepository) {
        this.softSkillRepository = softSkillRepository;
    }

    public void cadastrarSoftSkill(SoftSkill softSkill){
        softSkillRepository.save(softSkill);
    }
    public List<SoftSkill> listarSoftSkills(Long userId){
        return softSkillRepository.findSkills(userId);
    }

    public void deletarSoftSkill(Long id){
        softSkillRepository.deleteById(id);
    }
    public Optional<SoftSkill> buscarPorId(Long id){
        return softSkillRepository.findById(id);
    }
}
