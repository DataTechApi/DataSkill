package com.datatech.dataskill.entity.dto.response;


import com.datatech.dataskill.entity.model.SoftSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  UsuarioDTOResponse{
    private Long id;
    private String nome;
    private String email;

    private String cargo;
    private String departamento;
    private String telefone;
    List<SoftSkill> softSills;

}
