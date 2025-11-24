package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.DashboardClient;
import com.datatech.dataskill.client.UsuarioClient;
import com.datatech.dataskill.entities.dtos.response.DashboardDTOResponse;
import com.datatech.dataskill.entities.dtos.response.UsuarioDTOResponse;
import com.datatech.dataskill.entities.enums.Cargo;
import com.datatech.dataskill.entities.enums.Departamento;
import com.datatech.dataskill.entities.enums.Hard;
import com.datatech.dataskill.entities.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DashboardController {
    private final DashboardClient dashboardClient;
    private final UsuarioClient usuarioClient;

    public DashboardController(DashboardClient dashboardClient, UsuarioClient usuarioClient) {
        this.dashboardClient = dashboardClient;
        this.usuarioClient = usuarioClient;
    }

    @GetMapping("/diretor/dashboard")
    public ModelAndView dashboard() {
        List<DashboardDTOResponse> dashboard = dashboardClient.buscarDashboard();
        ModelAndView mv = new ModelAndView("diretor/dashboard");
        mv.addObject("labels", dashboard.stream().map(DashboardDTOResponse::getName).toList());
        mv.addObject("values", dashboard.stream().map(DashboardDTOResponse::getValue).toList());
        return mv;
    }
    @GetMapping("/diretor/listar-usuarios")
    public ModelAndView listarTodos(@RequestParam String skill) {
        ModelAndView mv = new ModelAndView("/diretor/listar-usuarios");
        List<UsuarioDTOResponse> usuarios = usuarioClient.buscarUsuarioHard(skill);
        mv.addObject("usuarios", usuarios);
        return mv;
    }
//    @GetMapping("/diretor/listar-usuarios")
//    public String detalhesSkill(@RequestParam String skill, Model model) {
//        // Recebe apenas o nome da skill
//        List<UsuarioDTOResponse> usuarios = usuarioClient.buscarUsuarioHard(skill);
//        //model.addAttribute("skill", skill);
//        model.addAttribute("usuarios", usuarios);
//
//        // Retorna para a página de detalhes
//        return "listar-usuarios";
//    }

}



