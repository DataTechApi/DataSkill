package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.response.DashboardDTOResponse;
import com.datatech.dataskill.entity.dto.response.SoftSkillDTOResponse;
import com.datatech.dataskill.service.DashboardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@Tag(name = "dashboard")
public class DashboradController {

    private final DashboardService dashboardService;

    public DashboradController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping()
    public ResponseEntity<List<DashboardDTOResponse>> listarHardskill(){
        List<DashboardDTOResponse> dashboard = dashboardService.listarHardkill();
        return ResponseEntity.status(HttpStatus.OK).body(dashboard);
    }
    @GetMapping("/softskill")
    public ResponseEntity<List<SoftSkillDTOResponse>> listarSoftskill(){
        List<SoftSkillDTOResponse> softSkills = dashboardService.listarSoftSkill();
        return ResponseEntity.status(HttpStatus.OK).body(softSkills);
    }
}
