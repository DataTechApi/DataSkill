package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.model.AutoAvaliacao;
import com.datatech.dataskill.entity.model.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoAvaliacaoRepository extends JpaRepository <AutoAvaliacao, Long> {
    @Query(value = "select * from auto_avaliacao s where s.id_usuario = :userId ", nativeQuery = true)
    List<AutoAvaliacao> findAutoAvaliacao(Long userId);
}