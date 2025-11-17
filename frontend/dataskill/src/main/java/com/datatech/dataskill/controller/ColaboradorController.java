package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.PerfilClient;
import com.datatech.dataskill.entities.dtos.response.UsuarioPerfilDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ColaboradorController {

    private final PerfilClient perfilClient;

    public ColaboradorController(PerfilClient perfilClient) {
        this.perfilClient = perfilClient;
    }

    @GetMapping("colaborador/perfil")
    public String perfil(Model model) {
        UsuarioPerfilDTO perfil = perfilClient.getById(LoginController.USUARIO_LOGADO);
        model.addAttribute("perfil", perfil);
        return "colaborador/perfil";
    }
                                                 
    @GetMapping("/colaborador/certificado")
    public String cadastrarCertificado() {
        return "colaborador/cadastrar-certificado";
    }       
    @GetMapping("/colaborador/experiencia")
    public String cadastrarExperiencia() {
        return "colaborador/cadastrar-experiencia";
    }       
          
    @GetMapping("/colaborador/autoavaliacao")
    public String cadastrarAutoavaliacao() {
        return "colaborador/cadastrar-autoavaliacao";
    } 
    @GetMapping("/colaborador/avaliacao")
    public String cadastrarAvaliacao() {
        return "colaborador/cadastrar-avaliacao";
    } 


}
