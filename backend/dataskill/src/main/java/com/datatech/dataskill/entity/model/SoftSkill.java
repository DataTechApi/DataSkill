package com.datatech.dataskill.entity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SoftSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private com.datatech.dataskill.entity.enums.Soft nome;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
