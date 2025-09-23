package com.datatech.dataskill.service;

import com.datatech.dataskill.entity.dto.request.LoginDTORequest;
import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

   private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Boolean realizarLogin(LoginDTORequest loginRequest){
        Optional<Usuario> login = usuarioRepository.findByEmail(loginRequest.email());
        if (login.isPresent()) {
            if (login.get().getSenha().equals(loginRequest.senha()) &&
                    login.get().getEmail().equals(loginRequest.email())) {
                return true;
            }
        }

        return false;
    }
}
