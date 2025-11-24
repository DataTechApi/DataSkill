package com.datatech.dataskill.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienciaDTORequest {
    private String nomeEmpresa;
    private String descricao;
    private String cargo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
