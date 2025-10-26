package com.datatech.dataskill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ColaboradorController {

    @GetMapping("/colaborador/perfil")
    public String perfil() {
        return "colaborador/perfil";
    }
    @GetMapping("/colaborador/cadastrar-hardskill")
    public String cadastrarHardSkill() {
        return "colaborador/cadastrar-hardskill";
    }       
    @GetMapping("/colaborador/cadastrar-certificado")
    public String cadastrarCertificado() {
        return "colaborador/cadastrar-certificado";
    }       
    @GetMapping("/colaborador/cadastrar-experiencia")
    public String cadastrarExperiencia() {
        return "colaborador/cadastrar-experiencia";
    }       
    @GetMapping("/colaborador/cadastrar-softskill")
    public String cadastrarSoftskill() {
        return "colaborador/cadastrar-softskill";
    }       
    @GetMapping("/colaborador/cadastrar-autoavaliacao")
    public String cadastrarAutoavaliacao() {
        return "colaborador/cadastrar-autoavaliacao";
    }       

}
