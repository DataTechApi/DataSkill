package com.datatech.dataskill.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.datatech.dataskill.entities.dtos.request.LoginDTO;
import com.datatech.dataskill.entities.dtos.response.LoginDTOResponse;

@Service
public class LoginService {

    private final RestClient restClient;
    public LoginService(RestClient restClient) {
        this.restClient = restClient;
    }

    public LoginDTOResponse logar(LoginDTO loginDTO) {
        String apiUrl = "http://localhost:8080/login";
        LoginDTOResponse response = restClient.post()
                .uri(apiUrl)
                .body(loginDTO)
                .retrieve()
                .body(LoginDTOResponse.class);
        return response;
    }
 }  
