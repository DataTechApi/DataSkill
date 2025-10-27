package com.datatech.dataskill.entity.dto.request;

import com.datatech.dataskill.entity.model.Usuario;

import java.time.LocalDate;

public record ExperienciaDTORequest(
        String nomeEmpresa,
        String cargo,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFim

) {}
