package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.model.Certificado;
import com.datatech.dataskill.service.CertificadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificado")
@Tag(name = "certificado-controller", description = "API de certificados")
public class CertificadoController {

    private final CertificadoService certificadoService;

    public CertificadoController(CertificadoService certificadoService) {
        this.certificadoService = certificadoService;
    }

    // Criar certificado
    @PostMapping
    @Operation(summary = "Cadastra um novo certificado")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Certificado criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar certificado")
    })
    public ResponseEntity<Certificado> cadastrar(@RequestBody Certificado request) {
        Certificado certificado = certificadoService.cadastrarCertificado(request);
        return ResponseEntity.status(201).body(certificado);
    }

    // Listar
    @GetMapping
    @Operation(summary = "Lista todos os certificados")
    public ResponseEntity<List<Certificado>> listar() {
        return ResponseEntity.ok(certificadoService.listarCertificados());
    }

    // Buscar  ID
    @GetMapping("/{id}")
    @Operation(summary = "Busca um certificado pelo ID")
    public ResponseEntity<Certificado> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(certificadoService.buscarPorId(id));
    }

    //Atualizar
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um certificado existente")
    public ResponseEntity<Certificado> atualizar(@PathVariable Long id, @RequestBody Certificado request) {
        return ResponseEntity.ok(certificadoService.atualizarCertificado(id, request));
    }

    //Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um certificado pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        certificadoService.deletarCertificado(id);
        return ResponseEntity.noContent().build();
    }
}