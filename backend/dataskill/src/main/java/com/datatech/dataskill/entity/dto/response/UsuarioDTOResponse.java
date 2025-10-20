package com.datatech.dataskill.entity.dto.response;

public record UsuarioDTOResponse(
        String nome,
        String email,
        ExperienciaDTOResponse experiencias
) {
}
