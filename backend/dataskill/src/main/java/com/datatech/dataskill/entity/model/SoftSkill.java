package com.datatech.dataskill.entity.model;

import com.datatech.dataskill.entity.enums.Soft;
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

    @Enumerated(EnumType.STRING)
    private Soft softSkill;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
