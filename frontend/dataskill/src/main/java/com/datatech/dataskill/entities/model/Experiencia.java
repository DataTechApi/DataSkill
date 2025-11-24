package com.datatech.dataskill.entities.model;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia {
    private Long id;
    private String nomeEmpresa;
    private String descricao;
    private String cargo;
    private LocalDate dataInicio;
    private LocalDate dataFim;


}
