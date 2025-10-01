package com.datatech.dataskill.entity.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome_empresa")
    private String nomeEmpresa;
   private String descricao;
    private String cargo;
    @Column(name="data_inicio")
    private LocalDate dataInicio;
    @Column(name="data_fim")
    private LocalDate dataFim;
}
