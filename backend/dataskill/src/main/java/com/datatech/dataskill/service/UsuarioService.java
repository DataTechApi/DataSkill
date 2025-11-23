package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);

    }
    public Optional<Usuario> buscarPorEmail(String email) {
        return Optional.ofNullable(usuarioRepository.findByEmail(email).orElse(null));
    }
    public Iterable<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
    public void alterarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }
}
