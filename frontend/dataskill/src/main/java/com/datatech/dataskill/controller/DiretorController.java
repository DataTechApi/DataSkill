package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.UsuarioClient;
import com.datatech.dataskill.entities.dtos.request.UsuarioDTORequest;
import com.datatech.dataskill.entities.dtos.response.UsuarioDTOResponse;
import com.datatech.dataskill.entities.dtos.response.UsuarioPerfilDTO;
import com.datatech.dataskill.entities.enums.Cargo;
import com.datatech.dataskill.entities.enums.Departamento;
import com.datatech.dataskill.entities.model.Usuario;
import com.datatech.dataskill.service.DataskillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller     
public class DiretorController {

    private final DataskillService dataskillService;
    private final UsuarioClient usuarioClient;
    public DiretorController(DataskillService dataskillService, UsuarioClient usuarioClient) {
        this.dataskillService = dataskillService;
        this.usuarioClient = usuarioClient;
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
    @GetMapping("/usuario/{id}")
    public String deletar(@PathVariable Long id){
        usuarioClient.deletarUsuario(id);
        return "redirect:/diretor/listar";
    }
    @GetMapping("/editar/user/{id}")
    public String editar(@PathVariable Long id, Model model){
        UsuarioDTOResponse usuario = usuarioClient.buscarUsuarioId(id);
        model.addAttribute("usuario",usuario);
        return "/diretor/editar";
    }
    @PutMapping("/usuario/{id}")
    public String alterarUsuario(@ModelAttribute UsuarioDTOResponse usuario, @PathVariable Long id){
        usuarioClient.alterarUsuario(usuario.getId(), usuario);
        return ("redirect:/diretor/listar");
    }
    @GetMapping("/visualizar/user/{id}")
    public String visualizarPerfil(@PathVariable Long id, Model model){
        UsuarioPerfilDTO usuario = usuarioClient.buscarPerfilId(id);
        model.addAttribute("usuario",usuario);
        return "/diretor/visualizar";
    }

}
