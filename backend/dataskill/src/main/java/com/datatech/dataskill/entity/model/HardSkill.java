package com.datatech.dataskill.entity.model;

import com.datatech.dataskill.entity.enums.Hard;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HardSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Hard nome;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
