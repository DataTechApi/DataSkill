package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.model.Certificado;
import com.datatech.dataskill.repository.CertificadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificadoService {

    private final CertificadoRepository certificadoRepository;

    public CertificadoService(CertificadoRepository certificadoRepository) {
        this.certificadoRepository = certificadoRepository;
    }

    // Criar
    public Certificado cadastrarCertificado(Certificado certificado) {
        return certificadoRepository.save(certificado);
    }

    // Listar
    public List<Certificado> listarCertificados(Long userId) {

        return certificadoRepository.findCertificado(userId);
    }

    // Buscar ID
    public Certificado buscarPorId(Long id) {
        return certificadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Certificado não encontrado com ID: " + id));
    }

    // Atualizar
    public Certificado atualizarCertificado(Long id, Certificado request) {
        Certificado existente = buscarPorId(id);
        existente.setNome(request.getNome());
        existente.setDataInicio(request.getDataInicio());
        existente.setDataFim(request.getDataFim());
        existente.setInstituicao(request.getInstituicao());
        return certificadoRepository.save(existente);
    }

    // Deletar
    public void deletarCertificado(Long id) {
        if (!certificadoRepository.existsById(id)) {
            throw new RuntimeException("Certificado não encontrado com ID: " + id);
        }
        certificadoRepository.deleteById(id);
    }
}