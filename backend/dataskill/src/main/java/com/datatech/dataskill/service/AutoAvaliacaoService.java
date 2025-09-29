
package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.model.AutoAvaliacao;
import com.datatech.dataskill.repository.AutoAvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoAvaliacaoService {
    private final AutoAvaliacaoRepository autoAvaliacaoRepository;

    public AutoAvaliacaoService(AutoAvaliacaoRepository autoAvaliacaoRepository) {
        this.autoAvaliacaoRepository = autoAvaliacaoRepository;
    }

    public AutoAvaliacao cadastrarAutoAvaliacao(AutoAvaliacao autoAvaliacao) {
        return autoAvaliacaoRepository.save(autoAvaliacao);
    }

    public List<AutoAvaliacao> buscarAutoAvaliacao() {
        return autoAvaliacaoRepository.findAll();
    }

    public void deletarAutoAvaliacao(Long id) {
        autoAvaliacaoRepository.deleteById(id);
    }

    public Optional<AutoAvaliacao> buscarAutoAvaliacaoId(Long id) {
        return autoAvaliacaoRepository.findById(id);
    }


}