package com.datatech.dataskill.entity.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExperiencia;

    @Column(name="nome_empresa")
    private String nomeEmpresa;
    @Column(name="cargo")
    private String cargo;
    @Column(name="data_inicio")
    private String dataInicio;
    @Column(name="data_fim")
    private String dataFim;  
}
