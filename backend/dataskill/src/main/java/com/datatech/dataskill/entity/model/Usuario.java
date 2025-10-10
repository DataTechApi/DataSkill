package com.datatech.dataskill.entity.model;

import com.datatech.dataskill.entity.enums.Cargo;
import com.datatech.dataskill.entity.enums.Hard;
import com.datatech.dataskill.entity.enums.Soft;
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

    @Column(unique = true)
    private String email;

    private String senha;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    private List<Soft> soft;

    private List<Hard> hard;

}
