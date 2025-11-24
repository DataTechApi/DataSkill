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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/{userId}")
    @Operation(summary = "Cria experiência do usuário",
            description = "Cria a experiência do usuário com os dados necessários")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarExperiencia(@PathVariable Long userId, @RequestBody ExperienciaDTORequest request) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(userId);
        Experiencia experiencia = modelMapper.map(request, Experiencia.class);
        experiencia.setUsuario(usuario.get());
        experienciaService.cadastrarExperiencia(experiencia);
        URI uri = URI.create(STR."/experiencia/\{experiencia.getId()}");
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{userId}")
    @Operation(summary = "Busca experiência por ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    public ResponseEntity<List<Experiencia>> buscarExperiencia(@PathVariable Long userId) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(userId);
        if (usuario.isPresent()) {
            List<Experiencia> experiencias = experienciaService.buscarExperiencia(usuario.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(experiencias);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarExperiencia(@PathVariable Long id) {
        Optional<Experiencia> experiencia = experienciaService.buscarPorId(id);
        if (experiencia.isPresent()) {
            experienciaService.deletarExperiencia(experiencia.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body("Experiência deletada com sucesso!!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Experiência não encontrada!!");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity updateExperiencia(@RequestBody ExperienciaDTORequest request, @PathVariable Long id) {
        Optional<Experiencia> experiencia = experienciaService.buscarPorId(id);
        if(experiencia.isPresent()){
           experiencia.get().setNomeEmpresa(request.nomeEmpresa());
           experiencia.get().setDescricao(request.descricao());
           experiencia.get().setCargo(request.cargo());
           experiencia.get().setDataInicio(request.dataInicio());
           experiencia.get().setDataFim(request.dataFim());
            experienciaService.alterarExperiencia(experiencia.get());
            return ResponseEntity.status(HttpStatus.OK).body("alteração realizada com sucesso!!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Experiência não encontrada!!");
        }

    }
    @GetMapping("/exp/{id}")
    public ResponseEntity<Experiencia> buscarExp(@PathVariable Long id){
        Optional<Experiencia> experiencia = experienciaService.buscarPorId(id);
        if (experiencia.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(experiencia.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}