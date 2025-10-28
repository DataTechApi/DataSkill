package com.datatech.dataskill.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SoftSkillService {

    private final RestClient restClient;
    public SoftSkillService(RestClient restClient) {
        this.restClient = restClient;
    }

    public void salvarSoftSkill(String softSkill) {
        String apiUrl = "http://localhost:8080/softskill";
        restClient.post()
                .uri(apiUrl)
                .body(softSkill)
                .retrieve()
                .toBodilessEntity();
    }

}
