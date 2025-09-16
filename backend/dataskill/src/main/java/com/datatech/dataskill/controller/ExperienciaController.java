package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.model.Experiencia;
import com.datatech.dataskill.service.ExperienciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/experiencia")
@Tag(name = "experienciacontroller")

public class ExperienciaController {
    private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @PostMapping
    @Operation(summary = "Cria experiência do usuário",
                description = "Cria a experiência do usuário com os dados necessários")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"),@ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarExperiencia(@RequestBody Experiencia request){
        Experiencia experiencia = new Experiencia();
        experiencia.setNomeEmpresa(request.getNomeEmpresa());
        experiencia.setCargo(request.getCargo());
        experiencia.setDataInicio(request.getDataInicio());
        experiencia.setDataFim(request.getDataFim());

        experienciaService.cadastrarExperiencia(experiencia);
        return ResponseEntity.ok().build();

    }

    
    @GetMapping("/{id}")
    @Operation(summary = "Busca experiência por ID")
    public ResponseEntity<Experiencia> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.of(experienciaService.buscarPorId(id));
    }

    

}