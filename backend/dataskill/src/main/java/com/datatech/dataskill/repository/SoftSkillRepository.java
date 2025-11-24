package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.model.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoftSkillRepository extends JpaRepository <SoftSkill,Long>{

    @Query(value = "select * from soft_skill s where s.id_usuario = :userId ", nativeQuery = true)
    List<SoftSkill> findSkills(Long userId);

}
