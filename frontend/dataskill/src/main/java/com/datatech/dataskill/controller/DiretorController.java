package com.datatech.dataskill.controller;

import java.util.List;

import com.datatech.dataskill.entities.dtos.request.HardSkillDTORequest;
import com.datatech.dataskill.entities.dtos.request.UsuarioDTORequest;
import com.datatech.dataskill.entities.dtos.response.HardSkillDTOResponse;
import com.datatech.dataskill.entities.enums.Cargo;
import com.datatech.dataskill.entities.enums.Departamento;
import com.datatech.dataskill.entities.enums.Hard;
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
    @GetMapping("/diretor/cadastrar")
    public ModelAndView cadastrar(){
        UsuarioDTORequest request = new UsuarioDTORequest();
        ModelAndView mv = new ModelAndView("diretor/cadastrar");
        mv.addObject("request", request);
        mv.addObject("departamento", Departamento.values());
        mv.addObject("cargo", Cargo.values());
        return mv;

    }

}
