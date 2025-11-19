package com.datatech.dataskill.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoDTORequest {
    private String nome;
    private String instituicao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
