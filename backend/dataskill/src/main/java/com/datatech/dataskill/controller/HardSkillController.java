package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.HardSkillDTORequest;
import com.datatech.dataskill.entity.dto.response.HardSkillDTOResponse;
import com.datatech.dataskill.entity.model.HardSkill;
import com.datatech.dataskill.service.HardSkillService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardskill")
@Tag(name = "hardskill")
public class HardSkillController {

    private final HardSkillService hardSkillService;

    public HardSkillController(HardSkillService hardSkillService) {
        this.hardSkillService = hardSkillService;
    }

    @PostMapping
    public ResponseEntity cadastrarHardSkill(@RequestBody HardSkillDTORequest request){
        HardSkill hardSkill = new HardSkill();
        hardSkill.setNome(request.nome());
        hardSkillService.cadastrarHardSkill(hardSkill);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");

    }
    @GetMapping
    public ResponseEntity<List<HardSkill>> listarHardSkills(){
        List<HardSkill> hardSkills = hardSkillService.listarHardSkills();
        return ResponseEntity.status(HttpStatus.OK).body(hardSkills);
    }
}
