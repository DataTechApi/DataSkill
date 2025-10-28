package com.datatech.dataskill.controller;

import com.datatech.dataskill.service.SoftSkillService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SoftSkillController {

    private final SoftSkillService softSkillService;

    public SoftSkillController(SoftSkillService softSkillService) {
        this.softSkillService = softSkillService;
    }

    @PostMapping()
    public void salvarSoftSkill(@PathVariable Long userId, @RequestBody SoftSkillDTORequest request){

    }
}
