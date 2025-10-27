package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.SoftSkillDTORequest;
import com.datatech.dataskill.entity.model.SoftSkill;
import com.datatech.dataskill.service.SoftSkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/softskill")
@Tag(name = "softskill")
public class SoftSkillController {

    private final SoftSkillService softSkillService;

    public SoftSkillController(SoftSkillService softSkillService) {
        this.softSkillService = softSkillService;
    }
    @PostMapping
    @Operation(summary = "Cria softskill", description = "Adiciona um softskill no cadastro do usuário")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarSoftSkill(@RequestBody SoftSkillDTORequest request){
        SoftSkill softSkill = new SoftSkill();
        softSkill.setNome(request.nome());
        softSkillService.cadastrarSoftSkill(softSkill);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");

    }
    @GetMapping
    @Operation(summary = "Busca todas as softskiils no banco de dados",
    description = "Realiza a busca de todas as softskills cadastradas no sistema")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<Iterable<SoftSkill>> listarSoftSkills(){
        List<SoftSkill> softSkills = softSkillService.listarSoftSkills();
        return ResponseEntity.status(HttpStatus.OK).body(softSkills);
    }
}
