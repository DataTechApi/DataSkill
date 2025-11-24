package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.model.Experiencia;
import com.datatech.dataskill.repository.ExperienciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaService {

    private final ExperienciaRepository experienciaRepository;


    public ExperienciaService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }
    public Optional<Experiencia> buscarPorId(Long id){
        return experienciaRepository.findById(id);
    }
    public void deletarExperiencia(Long id){
        experienciaRepository.deleteById(id);
    }

    public void cadastrarExperiencia(Experiencia experiencia){
        experienciaRepository.save(experiencia);
    }

    public List<Experiencia> buscarExperiencia(Long userId) {
        return experienciaRepository.findExperiencia(userId);
    }

    public void alterarExperiencia(Experiencia experiencia){
        experienciaRepository.save(experiencia);
    }
}
