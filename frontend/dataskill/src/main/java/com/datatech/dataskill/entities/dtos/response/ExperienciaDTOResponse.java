package com.datatech.dataskill.entities.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienciaDTOResponse {
    private Long id;
    private String nomeEmpresa;
    private String descricao;
    private String cargo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
