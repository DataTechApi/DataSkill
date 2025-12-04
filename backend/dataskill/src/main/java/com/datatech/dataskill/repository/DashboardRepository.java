package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.dto.response.DashboardDTOResponse;
import com.datatech.dataskill.entity.dto.response.SoftSkillDTOResponse;
import com.datatech.dataskill.entity.model.HardSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<HardSkill,Long> {

    @Query(value = "select h.nome as name, count(*) as value from hard_skill h\n" +
            "group by h.nome", nativeQuery = true)
    List<DashboardDTOResponse> listarHardskill();

    @Query(value = "select s.nome as name, count(*) as value from soft_skill s\n" +
            "group by s.nome", nativeQuery = true)
    List<SoftSkillDTOResponse> listarSoftskill();
}
