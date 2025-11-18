package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.SoftSkillDTORequest;
import com.datatech.dataskill.entity.dto.response.SoftSkillDTOResponse;
import com.datatech.dataskill.entity.model.SoftSkill;
import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.service.SoftSkillService;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/softskill")
@Tag(name = "softskill")
public class SoftSkillController {

    private final SoftSkillService softSkillService;
    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper;

    public SoftSkillController(SoftSkillService softSkillService, UsuarioService usuarioService, ModelMapper modelMapper) {
        this.softSkillService = softSkillService;
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/{userId}")
    @Operation(summary = "Cria softskill", description = "Adiciona um softskill no cadastro do usuário")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarSoftSkill(@PathVariable Long userId, @RequestBody SoftSkillDTORequest request) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(userId);
        SoftSkill softSkill = modelMapper.map(request, SoftSkill.class);
        softSkill.setUsuario(usuario.get());
        softSkillService.cadastrarSoftSkill(softSkill);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");

    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<SoftSkill>> listarSoftSkills(@PathVariable Long userId) {
        Optional<Usuario> usuario =usuarioService.buscarPorId(userId);
        if(usuario.isPresent()){
            List<SoftSkill> softSkills = softSkillService.listarSoftSkills(usuario.get().getId());

            return ResponseEntity.status(HttpStatus.OK).body(softSkills);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
