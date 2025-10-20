package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.ExperienciaDTORequest;
import com.datatech.dataskill.entity.model.Experiencia;
import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.service.ExperienciaService;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/experiencia")
@Tag(name = "experiencia")

public class ExperienciaController {
    private final ExperienciaService experienciaService;
    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper;
    public ExperienciaController(ExperienciaService experienciaService, UsuarioService usuarioService, ModelMapper modelMapper) {
        this.experienciaService = experienciaService;
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/{id}")
    @Operation(summary = "Cria experiência do usuário",
                description = "Cria a experiência do usuário com os dados necessários")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"),@ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarExperiencia(@PathVariable Long id,@RequestBody ExperienciaDTORequest request){
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        Experiencia experiencia = modelMapper.map(request,Experiencia.class);
        experiencia.setUsuario(usuario.get());
        experienciaService.cadastrarExperiencia(experiencia);
        URI uri = URI.create(STR."/experiencia/\{experiencia.getId()}");
        return ResponseEntity.created(uri).build();

    }

    
    @GetMapping("/{id}")
    @Operation(summary = "Busca experiência por ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"),@ApiResponse(responseCode = "404")})
    public ResponseEntity<Experiencia> buscarPorId(@PathVariable Long id) {
        Optional<Experiencia> experiencia = experienciaService.buscarPorId(id);
        if(experiencia.isPresent())
            return ResponseEntity.ok(experiencia.get());
        else
            return ResponseEntity.notFound().build();
    }

    

}