package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.dto.response.UsuarioDTOResponse;
import com.datatech.dataskill.entity.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);

    }
