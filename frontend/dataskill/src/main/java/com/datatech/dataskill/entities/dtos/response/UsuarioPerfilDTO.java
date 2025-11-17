package com.datatech.dataskill.entities.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPerfilDTO {
    private String email;
    private String nome;
    private String cargo;
    private String telefone;
    private String departamento;

}
