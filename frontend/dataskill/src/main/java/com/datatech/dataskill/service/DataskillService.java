package com.datatech.dataskill.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.datatech.dataskill.entities.model.Usuario;

@Service
public class DataskillService {

    private final RestClient restClient;
    public DataskillService(RestClient restClient) {
        this.restClient = restClient;
    }
    
    public List<Usuario> listarTodos() {
        String apiUrl = "http://localhost:8080/usuario";
        List<Usuario> usuarios = restClient.get()
                .uri(apiUrl)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return usuarios;          
    
    }
    public void salvarUsuario(Usuario usuario) {
        String apiUrl = "http://localhost:8080/usuario";
        restClient.post()
                .uri(apiUrl)
                .body(usuario)
                .retrieve()
                .toBodilessEntity();
    }

}
