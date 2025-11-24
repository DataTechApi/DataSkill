package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.dto.response.UsuarioDTOResponse;
import com.datatech.dataskill.entity.dto.response.UsuarioPerfilDTOResponse;
import com.datatech.dataskill.entity.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);

    @Query(value = "SELECT u.id,u.nome,u.email,u.cargo,u.departamento,u.telefone " +
            "FROM usuario u " +
            "INNER JOIN hard_skill h ON u.id = h.id_usuario " +
            "WHERE h.nome LIKE %:skill", nativeQuery = true)
    List<UsuarioPerfilDTOResponse> buscarUsuarioHard(String skill);

    }
