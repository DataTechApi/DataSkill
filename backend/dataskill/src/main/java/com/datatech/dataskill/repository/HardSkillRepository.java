package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.model.HardSkill;
import com.datatech.dataskill.entity.model.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardSkillRepository extends JpaRepository<HardSkill, Long> {
    @Query(value = "select * from hard_skill s where s.id_usuario = :userId ", nativeQuery = true)
    List<HardSkill> findHardSkills(Long userId);
}
