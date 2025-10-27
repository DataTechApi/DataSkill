package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.model.HardSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillRepository extends JpaRepository<HardSkill, Long> {
}
