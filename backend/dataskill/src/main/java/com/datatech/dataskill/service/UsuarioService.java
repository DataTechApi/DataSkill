package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(Usuario usuario){

        usuarioRepository.save(usuario);

    }
}
