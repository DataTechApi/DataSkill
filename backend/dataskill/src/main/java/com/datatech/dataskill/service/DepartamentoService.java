package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.model.Departamento;
import com.datatech.dataskill.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public void cadastrarDepartamento(Departamento departamento){
        departamentoRepository.save(departamento);
    }

    public List<Departamento> listarDepartamentos(){
        return departamentoRepository.findAll();
    }
}
