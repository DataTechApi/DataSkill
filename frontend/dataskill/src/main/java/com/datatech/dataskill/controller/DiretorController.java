package com.datatech.dataskill.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.datatech.dataskill.entities.model.Usuario;
import com.datatech.dataskill.service.DataskillService;





@Controller     
public class DiretorController {

    private final DataskillService dataskillService;
    public DiretorController(DataskillService dataskillService) {
        this.dataskillService = dataskillService;
    }

    
    @GetMapping("/diretor/cadastrar")
    public String cadastrar() {
        return "diretor/cadastrar";
    }

    @GetMapping("/diretor/listar")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("diretor/listar");
        List<Usuario> usuarios = dataskillService.listarTodos();
        mv.addObject("usuarios", usuarios);
        return mv;
    }
    @PostMapping("/diretor/cadastrar")
    public ModelAndView salvarUsuario(Usuario usuario) {
        dataskillService.salvarUsuario(usuario);
        return new ModelAndView("redirect:/diretor/listar");
    }

}
