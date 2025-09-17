package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.model.Avaliacao;
import com.datatech.dataskill.service.AvaliacaoService;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/avaliacao")
@Tag(name = "avaliacao-controller")


public class AvaliacaoController {
    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }
    @PostMapping
    @Operation(summary = "Cria avaliacao no sistema",
            description = "Cria a avaliacao do colaborador no sistema")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"),@ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarAvaliacao(@RequestBody Avaliacao request){
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setDescricao(request.getDescricao());
        avaliacao.setDataAvaliacao(request.getDataAvaliacao());
        URI uri = URI.create("/usuario/"+avaliacao.getId());
        avaliacaoService.cadastrarAvaliacao(avaliacao);
        return ResponseEntity.created(uri).build();
    }
}

