package com.datatech.dataskill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ColaboradorController {

    @GetMapping("/colaborador/perfil")
    public String perfil() {
        return "colaborador/perfil";
    }

}
