package com.datatech.dataskill.entities.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Long id;
    private String nome;
    private String email;   
    private String cargo;
    private String departamento;
    private String telefone;

}
