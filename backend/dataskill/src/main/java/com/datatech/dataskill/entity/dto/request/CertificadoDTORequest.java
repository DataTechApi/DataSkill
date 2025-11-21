package com.datatech.dataskill.entity.dto.request;

import java.time.LocalDate;

public record CertificadoDTORequest(
        String nome, String instituicao,
        LocalDate dataInicio, LocalDate dataFim
        ) {
}
