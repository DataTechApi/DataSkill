package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.DashboardClient;
import com.datatech.dataskill.client.UsuarioClient;
import com.datatech.dataskill.entities.dtos.response.DashSoftskillDTOResponse;
import com.datatech.dataskill.entities.dtos.response.DashboardDTOResponse;
import com.datatech.dataskill.entities.dtos.response.UsuarioDTOResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/diretor/dashhardskill")
    public ModelAndView dashboard() {
        List<DashboardDTOResponse> dashboard = dashboardClient.buscarDashboard();
        ModelAndView mv = new ModelAndView("diretor/dashhardskill");
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
    @GetMapping("/diretor/dashsoftskill")
    public ModelAndView dashboardSoftskill() {
        List<DashSoftskillDTOResponse> dashboardSoftskill = dashboardClient.buscarSoftskills();
        ModelAndView mv = new ModelAndView("diretor/dashsoftskill");
        mv.addObject("labels", dashboardSoftskill.stream().map(DashSoftskillDTOResponse::getName).toList());
        mv.addObject("values", dashboardSoftskill.stream().map(DashSoftskillDTOResponse::getValue).toList());
        return mv;
    }
   @GetMapping("/diretor/listar-usuariossoft")
    public ModelAndView listarTodosSoft(@RequestParam String skill) {
        ModelAndView mv = new ModelAndView("/diretor/listar-usuarios");
        List<UsuarioDTOResponse> usuarios = usuarioClient.buscarUsuarioSoft(skill);
        mv.addObject("usuarios", usuarios);
        return mv;
    }
}



