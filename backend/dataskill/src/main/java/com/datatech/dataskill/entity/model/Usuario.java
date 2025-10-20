package com.datatech.dataskill.entity.model;

import com.datatech.dataskill.entity.enums.Cargo;
import com.datatech.dataskill.entity.enums.Hard;
import com.datatech.dataskill.entity.enums.Soft;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Getter
@Setter

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
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
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @OneToMany(mappedBy = ("usuario"), fetch = FetchType.EAGER)
    private List<SoftSkill> softSkills;

    @OneToMany(mappedBy = ("usuario"), fetch = FetchType.EAGER)
    private List<HardSkill> hardSkills;

    @OneToMany(mappedBy = ("usuario"), fetch = FetchType.EAGER)
    private List<Avaliacao> avaliacoes;

    @OneToMany(mappedBy = ("usuario"), cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = ("usuario"), cascade = CascadeType.ALL)
    private List<Certificado> certificados;

    @OneToOne
    @JoinColumn(name = "auto_avaliacao_id")
    private AutoAvaliacao autoAvaliacao;
    }