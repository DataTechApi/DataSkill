package com.datatech.dataskill.controller;

import com.datatech.dataskill.client.CertificadoClient;
import com.datatech.dataskill.entities.dtos.request.CertificadoDTORequest;
import com.datatech.dataskill.entities.dtos.response.CertificadoDTOResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CertificadoController {
    
    private final CertificadoClient certificadoClient;
    
    public CertificadoController(CertificadoClient certificadoClient) {
        this.certificadoClient = certificadoClient;
    }
    @GetMapping("/colaborador/certificado")
    public ModelAndView listar(){
        CertificadoDTORequest request = new CertificadoDTORequest();
        ModelAndView mv = new ModelAndView("colaborador/cadastrar-certificado");
        List<CertificadoDTOResponse> certificados = certificadoClient.listarCertificado(LoginController.USUARIO_LOGADO);
        mv.addObject("request", request);
        mv.addObject("cert", certificados);
        return mv;
    }
    @PostMapping("/cadastrarCer")
    public ModelAndView salvar(CertificadoDTORequest request){
        certificadoClient.cadastrarCertificado(LoginController.USUARIO_LOGADO, request);
        return new ModelAndView("redirect:/colaborador/certificado");
    }
    @GetMapping("/certificado/{id}")
    public String deletar(@PathVariable Long id){
        certificadoClient.deletarCertificado(id);
        return "redirect:/colaborador/certificado";
    }
    @GetMapping("/editar/cert/{id}")
    public String editar(@PathVariable Long id, Model model){
        CertificadoDTOResponse certificado = certificadoClient.buscarPorId(id);
        model.addAttribute("certificado", certificado);
        return "/colaborador/editar-certificado";
    }
    @PutMapping("/certificado/{id}")
    public String alaterarCertificado(@ModelAttribute CertificadoDTOResponse certificado, @PathVariable Long id){
        certificadoClient.alterarCertificado(certificado.getId(), certificado);
        return ("redirect:/colaborador/certificado");
    }
}
