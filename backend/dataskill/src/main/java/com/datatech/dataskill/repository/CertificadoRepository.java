package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import com.datatech.dataskill.entity.model.Certificado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {

    @Query(value = "select * from certificado s where s.id_usuario = :userId ", nativeQuery = true)
    List<Certificado> findCertificado(Long userId);
}
