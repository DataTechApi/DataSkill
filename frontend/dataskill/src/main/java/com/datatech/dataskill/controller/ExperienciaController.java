package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.ExperienciaClient;
import com.datatech.dataskill.entities.dtos.request.ExperienciaDTORequest;
import com.datatech.dataskill.entities.dtos.response.ExperienciaDTOResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExperienciaController {
     private final ExperienciaClient experienciaClient;

    public ExperienciaController(ExperienciaClient experienciaClient) {
        this.experienciaClient = experienciaClient;
    }
    @GetMapping("/colaborador/experiencia")
    public ModelAndView listar(){
        ExperienciaDTORequest request = new ExperienciaDTORequest();
        ModelAndView mv = new ModelAndView("colaborador/cadastrar-experiencia");
        List<ExperienciaDTOResponse> experiencias = experienciaClient.listarExperiencia(LoginController.USUARIO_LOGADO);
        mv.addObject("request", request);
        mv.addObject("exper", experiencias);
        return mv;
    }
    @PostMapping("/cadastrarExp")
    public ModelAndView salvar(ExperienciaDTORequest request){
        experienciaClient.cadastrarExperiencia(LoginController.USUARIO_LOGADO, request);
        return new ModelAndView("redirect:/colaborador/experiencia");
    }
}
