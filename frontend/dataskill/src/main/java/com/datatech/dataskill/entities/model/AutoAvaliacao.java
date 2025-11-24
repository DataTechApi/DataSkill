package com.datatech.dataskill.entities.model;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AutoAvaliacao {

    private long id;

    private String descricao;

    private LocalDate dataAutoAvaliacao;


}