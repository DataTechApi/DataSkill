package com.datatech.dataskill.entity.model;

import com.datatech.dataskill.entity.enums.Hard;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
