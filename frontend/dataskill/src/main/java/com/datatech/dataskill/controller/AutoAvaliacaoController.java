package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.AutoAvaliacaoClient;
import com.datatech.dataskill.client.CertificadoClient;
import com.datatech.dataskill.entities.dtos.request.AutoAvaliacaoDTORequest;
import com.datatech.dataskill.entities.dtos.request.CertificadoDTORequest;
import com.datatech.dataskill.entities.dtos.response.AutoAvaliacaoDTOResponse;
import com.datatech.dataskill.entities.dtos.response.CertificadoDTOResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
