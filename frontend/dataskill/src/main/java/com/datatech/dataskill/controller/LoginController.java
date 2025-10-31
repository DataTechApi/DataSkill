package com.datatech.dataskill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.datatech.dataskill.entities.dtos.request.LoginDTO;
import com.datatech.dataskill.entities.dtos.response.LoginDTOResponse;
import com.datatech.dataskill.entities.model.Usuario;
import com.datatech.dataskill.service.LoginService;

@Controller
public class LoginController {

    public static Long USUARIO_LOGADO;;
    private final LoginService loginService;
     

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @PostMapping("/logar")
    public String autenticar(Model model, LoginDTO loginDTO) {
        try {
            LoginDTOResponse response = loginService.logar(loginDTO);
            if (response.getCargo().equals("SUPERVISOR")) {
                USUARIO_LOGADO=response.getId();
               
                return "redirect:/diretor/listar";
                
            } else if (response.getCargo().equals("DIRETOR")) {
                USUARIO_LOGADO=response.getId();
                return "redirect:/diretor/listar";
            }
            else{
                USUARIO_LOGADO=response.getId();
                return "redirect:/colaborador/perfil";
            }
        } catch (Exception e) {
            model.addAttribute("erro", "Usuário ou senha inválidos");
            return "redirect:/login";
        }

    }

}
