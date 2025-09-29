package com.datatech.dataskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.datatech.dataskill.entity.model.Certificado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {
}
