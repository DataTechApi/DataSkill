package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.model.Departamento;
import com.datatech.dataskill.service.DepartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamento")
@Tag(name = "departamento")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }
    @PostMapping
    @Operation(summary = "Cadastra departamento", description = "Cadastra um departamento no sistema")
    @ApiResponses(value= {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarDepartamento(@RequestBody Departamento request){
        Departamento departamento = new Departamento();
        departamento.setNome(request.getNome());
        departamentoService.cadastrarDepartamento(departamento);
        URI uri = URI.create("/departamento/"+departamento.getId());
        return ResponseEntity.created(uri).build();

    }
    @GetMapping
    @Operation(summary = "Busca todos os departamentos no banco de dados", description = "Realiza a busca dos departamentos no banco de dados")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<List<Departamento>> listarDepartamentos(){

        return ResponseEntity.ok(departamentoService.listarDepartamentos());
    }
}
