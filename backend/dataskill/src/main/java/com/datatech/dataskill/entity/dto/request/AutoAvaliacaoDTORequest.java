package com.datatech.dataskill.entity.dto.request;

import java.time.LocalDate;

public record AutoAvaliacaoDTORequest(
        String descricao,
        LocalDate dataAutoAvaliacao
) {  }
