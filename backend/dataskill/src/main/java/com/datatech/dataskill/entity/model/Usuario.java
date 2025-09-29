package com.datatech.dataskill.entity.model;

import com.datatech.dataskill.entity.enums.Cargo;
import com.datatech.dataskill.entity.enums.HardSkill;
import com.datatech.dataskill.entity.enums.SoftSkill;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @Enumerated(EnumType.STRING)
    private List<SoftSkill> soft;
    @Enumerated(EnumType.STRING)
    private List<HardSkill> hard;

}
