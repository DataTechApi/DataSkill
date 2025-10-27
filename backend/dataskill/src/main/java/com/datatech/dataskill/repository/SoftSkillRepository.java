package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.model.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillRepository extends JpaRepository <SoftSkill,Long>{
}
