package com.datatech.dataskill.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.datatech.dataskill.controller.LoginController;
import com.datatech.dataskill.entities.dtos.request.SoftSkillDTORequest;

@Service
public class SoftSkillService {

    private final RestClient restClient;
    public SoftSkillService(RestClient restClient) {
        this.restClient = restClient;
    }

    public void salvarSoftSkill(SoftSkillDTORequest request) {
        String apiUrl = "http://localhost:8080/softskill/";
        restClient.post()
                .uri(apiUrl  + LoginController.USUARIO_LOGADO)
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

}
