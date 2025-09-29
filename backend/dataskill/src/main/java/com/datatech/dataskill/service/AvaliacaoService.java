package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.model.Avaliacao;
import com.datatech.dataskill.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public void cadastrarAvaliacao(Avaliacao avaliacao){
        avaliacaoRepository.save(avaliacao);
    }
}
