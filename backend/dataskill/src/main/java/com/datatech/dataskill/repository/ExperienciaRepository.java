package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.model.Experiencia;
import com.datatech.dataskill.entity.model.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia,Long>{

    @Query(value = "select * from experiencia s where s.id_usuario = :userId ", nativeQuery = true)
    List<Experiencia> findExperiencia(Long userId);
}
