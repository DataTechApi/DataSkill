package com.datatech.dataskill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ColaboradorController {

    @GetMapping("/colaborador/perfil")
    public String perfil() {
        return "colaborador/perfil";
    }
    @GetMapping("/colaborador/hardskill")
    public String cadastrarHardSkill() {
        return "colaborador/cadastrar-hardskill";
    }                                                   
    @GetMapping("/colaborador/certificado")
    public String cadastrarCertificado() {
        return "colaborador/cadastrar-certificado";
    }       
    @GetMapping("/colaborador/experiencia")
    public String cadastrarExperiencia() {
        return "colaborador/cadastrar-experiencia";
    }       
    @GetMapping("/colaborador/softskill")
    public String cadastrarSoftskill() {
        return "colaborador/cadastrar-softskill";
    }       
    @GetMapping("/colaborador/autoavaliacao")
    public String cadastrarAutoavaliacao() {
        return "colaborador/cadastrar-autoavaliacao";
    } 


}
