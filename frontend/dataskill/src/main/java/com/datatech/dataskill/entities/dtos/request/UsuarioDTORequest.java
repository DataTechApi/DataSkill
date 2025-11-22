package com.datatech.dataskill.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTORequest {
    private String nome;
    private String email;
    private String cargo;
    private String senha;
    private String departamento;
    private String telefone;
}
