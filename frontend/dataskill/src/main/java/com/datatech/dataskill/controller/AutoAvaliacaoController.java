package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.AutoAvaliacaoClient;
import com.datatech.dataskill.entities.dtos.request.AutoAvaliacaoDTORequest;
import com.datatech.dataskill.entities.dtos.response.AutoAvaliacaoDTOResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AutoAvaliacaoController {
    private final AutoAvaliacaoClient autoAvaliacaoClient;

    public AutoAvaliacaoController(AutoAvaliacaoClient autoAvaliacaoClient) {
        this.autoAvaliacaoClient = autoAvaliacaoClient;
    }


    @GetMapping("/colaborador/autoavaliacao")
    public ModelAndView listar(){
        AutoAvaliacaoDTORequest request = new AutoAvaliacaoDTORequest();
        ModelAndView mv = new ModelAndView("colaborador/cadastrar-autoavaliacao");
        List<AutoAvaliacaoDTOResponse> autoAvaliacao = autoAvaliacaoClient.listarAutoAvaliacao(LoginController.USUARIO_LOGADO);
        mv.addObject("request", request);
        mv.addObject("auto", autoAvaliacao);
        return mv;
    }
    @PostMapping("/cadastrarAuto")
    public ModelAndView salvar(AutoAvaliacaoDTORequest request){
        autoAvaliacaoClient.cadastrarAutoAvaliacao(LoginController.USUARIO_LOGADO, request);
        return new ModelAndView("redirect:/colaborador/autoavaliacao");
    }
    @GetMapping("/autoavaliacao/{id}")
    public String deletar(@PathVariable Long id){
        autoAvaliacaoClient.deletarAutoAvalicao(id);
        return "redirect:/colaborador/autoavaliacao";
    }
    @GetMapping("/editar/auto/{id}")
    public String editar(@PathVariable Long id, Model model){
       AutoAvaliacaoDTOResponse autoAvaliacao = autoAvaliacaoClient.buscarPorId(id);
        model.addAttribute("autoavaliacao",autoAvaliacao);
        return "/colaborador/editar-autoavaliacao";
    }
    @PutMapping("/autoavaliacao/{id}")
    public String alterarAutoAvaliacao(@ModelAttribute AutoAvaliacaoDTOResponse autoAvaliacao, @PathVariable Long id){
        autoAvaliacaoClient.alterarAutoAvaliacao(autoAvaliacao.getId(), autoAvaliacao);
        return ("redirect:/colaborador/autoavaliacao");
    }
}
