package com.datatech.dataskill.entity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Column(name = "data_avaliacao")
    private Date dataAvaliacao;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


}
