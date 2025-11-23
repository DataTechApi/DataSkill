package com.datatech.dataskill.entities.dtos.response;

import com.datatech.dataskill.entities.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPerfilDTO {
    private Long id;
    private String nome;
    private String email;

    private String cargo;
    private String departamento;
    private String telefone;

    List<SoftSkill> softSkills;
    List<HardSkill> hardSkills;
    List<Experiencia> experiencias;
    List<Certificado> certificados;
    List<AutoAvaliacao> autoAvaliacao;
}
