package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.HardSkillDTORequest;
import com.datatech.dataskill.entity.dto.response.HardSkillDTOResponse;
import com.datatech.dataskill.entity.model.HardSkill;
import com.datatech.dataskill.entity.model.SoftSkill;
import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.service.HardSkillService;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hardskill")
@Tag(name = "hardskill")
public class HardSkillController {

    private final HardSkillService hardSkillService;
    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper;

    public HardSkillController(HardSkillService hardSkillService, UsuarioService usuarioService, ModelMapper modelMapper) {
        this.hardSkillService = hardSkillService;
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/{userId}")
    public ResponseEntity cadastrarHardSkill(@PathVariable Long userId, @RequestBody HardSkillDTORequest request){
        Optional<Usuario> usuario = usuarioService.buscarPorId(userId);
        HardSkill hardSkill  = modelMapper.map(request,HardSkill.class);
        hardSkill.setUsuario(usuario.get());
        hardSkillService.cadastrarHardSkill(hardSkill);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");

    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<HardSkill>> listarHardSkills(@PathVariable Long userId){
        Optional<Usuario> usuario = usuarioService.buscarPorId(userId);
        if(usuario.isPresent()){
            List<HardSkill> hardSkills = hardSkillService.listarHardSkills(usuario.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(hardSkills);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
