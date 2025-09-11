package com.datatech.dataskill.repository;

import com.datatech.dataskill.entity.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
