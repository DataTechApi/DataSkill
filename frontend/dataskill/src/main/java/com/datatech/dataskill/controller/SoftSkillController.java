package com.datatech.dataskill.controller;

import com.datatech.dataskill.entities.dtos.request.SoftSkillDTORequest;
import com.datatech.dataskill.entities.enums.Soft;
import com.datatech.dataskill.service.SoftSkillService;

import lombok.extern.java.Log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SoftSkillController {

    private final SoftSkillService softSkillService;

    public SoftSkillController(SoftSkillService softSkillService) {
        this.softSkillService = softSkillService;
    }

    
    @GetMapping("/colaborador/softskill")
    public ModelAndView listar(){
        SoftSkillDTORequest request = new SoftSkillDTORequest();
        ModelAndView mv = new ModelAndView("colaborador/cadastrar-softskill");
        mv.addObject("request", request);
        mv.addObject("softskill", Soft.values());
        return mv;

    }
    @PostMapping("/cadastrar")
    public ModelAndView salvar(SoftSkillDTORequest request){
        softSkillService.salvarSoftSkill(request);
        return new ModelAndView("redirect:/colaborador/softskill");
    }   
}
