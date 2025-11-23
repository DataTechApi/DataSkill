package com.datatech.dataskill.entities.model;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Certificado {

    private Long id;

    private String nome;

    private String instituicao;


    private LocalDate dataInicio;


    private LocalDate dataFim;

}
