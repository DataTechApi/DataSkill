package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.model.Certificado;
import com.datatech.dataskill.repository.CertificadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificadoService {

    private final CertificadoRepository certificadoRepository;

    public CertificadoService(CertificadoRepository certificadoRepository) {
        this.certificadoRepository = certificadoRepository;
    }
    public void cadastrarCertificado(Certificado certificado) {
        certificadoRepository.save(certificado);
    }

    public List<Certificado> listarCertificados(Long userId) {

        return certificadoRepository.findCertificado(userId);
    }
    public Optional<Certificado> buscarPorId(Long id) {
        return certificadoRepository.findById(id);

    }
    public void atualizarCertificado( Certificado certificado) {
        certificadoRepository.save(certificado);
    }
    public void deletarCertificado(Long id) {
        if (!certificadoRepository.existsById(id)) {
            throw new RuntimeException("Certificado não encontrado com ID: " + id);
        }
        certificadoRepository.deleteById(id);
    }
}