package com.datatech.dataskill.entity.dto.response;

import java.time.LocalDate;

public record ExperienciaDTOResponse(
        String nomeEmpresa,
        String cargo,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFim
) {
}
