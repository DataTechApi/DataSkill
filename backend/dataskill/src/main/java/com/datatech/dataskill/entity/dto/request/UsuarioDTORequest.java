package com.datatech.dataskill.entity.dto.request;

public record UsuarioDTORequest(
        String nome,
        String email,
        String senha,
        String telefone,
        String departamento,
        String cargo

) {}