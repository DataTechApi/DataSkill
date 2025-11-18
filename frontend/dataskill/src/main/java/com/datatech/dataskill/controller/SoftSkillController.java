package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.SoftSkillClient;
import com.datatech.dataskill.entities.dtos.request.SoftSkillDTORequest;
import com.datatech.dataskill.entities.dtos.response.SoftSkillDTOResponse;
import com.datatech.dataskill.entities.enums.Soft;
import com.datatech.dataskill.service.SoftSkillService;

import lombok.extern.java.Log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SoftSkillController {


    private final SoftSkillClient softSkillClient;

    public SoftSkillController(SoftSkillClient softSkillClient) {
        this.softSkillClient = softSkillClient;
    }


    @GetMapping("/colaborador/softskill")
    public ModelAndView listar() {
        SoftSkillDTORequest request = new SoftSkillDTORequest();
        ModelAndView mv = new ModelAndView("colaborador/cadastrar-softskill");
        List<SoftSkillDTOResponse> softSkills = softSkillClient.listarSoftSkill(LoginController.USUARIO_LOGADO);
        mv.addObject("request", request);
        mv.addObject("softskill", Soft.values());
        mv.addObject("skill", softSkills);
        return mv;

    }

    @PostMapping("/cadastrarSoft")
    public ModelAndView salvar(SoftSkillDTORequest request) {
        softSkillClient.cadastrarSoftSkill(LoginController.USUARIO_LOGADO,
                request);
        return new ModelAndView("redirect:/colaborador/softskill");
    }
}
