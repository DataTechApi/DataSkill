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
public class CertificadoDTOResponse {
    private Long id;
    private String nome;
    private String instituicao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
