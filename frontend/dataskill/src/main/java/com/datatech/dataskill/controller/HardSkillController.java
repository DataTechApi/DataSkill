package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.HardSkillClient;
import com.datatech.dataskill.entities.dtos.request.HardSkillDTORequest;
import com.datatech.dataskill.entities.dtos.request.SoftSkillDTORequest;
import com.datatech.dataskill.entities.dtos.response.HardSkillDTOResponse;
import com.datatech.dataskill.entities.dtos.response.SoftSkillDTOResponse;
import com.datatech.dataskill.entities.enums.Hard;
import com.datatech.dataskill.entities.enums.Soft;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HardSkillController {

    private final HardSkillClient hardSkillClient;

    public HardSkillController(HardSkillClient hardSkillClient) {
        this.hardSkillClient = hardSkillClient;
    }
    @GetMapping("/colaborador/hardskill")
    public ModelAndView listar(){
        HardSkillDTORequest request = new HardSkillDTORequest();
        ModelAndView mv = new ModelAndView("colaborador/cadastrar-hardskill");
        List<HardSkillDTOResponse> hardSkills = hardSkillClient.listarHardSkill(LoginController.USUARIO_LOGADO);
        mv.addObject("request", request);
        mv.addObject("hardskill", Hard.values());
        mv.addObject("skill", hardSkills);
        return mv;

    }
    @PostMapping("/cadastrarHard")
    public ModelAndView salvar(HardSkillDTORequest request){
        hardSkillClient.cadastrarHardSkill(LoginController.USUARIO_LOGADO, request);
        return new ModelAndView("redirect:/colaborador/hardskill");
    }

}
