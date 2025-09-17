package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.model.AutoAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoAvaliacaoRepository extends JpaRepository <AutoAvaliacao, Long> {
//    List<AutoAvaliacao> id(long id);
}