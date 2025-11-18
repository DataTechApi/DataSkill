package com.datatech.dataskill.client;

import com.datatech.dataskill.controller.LoginController;
import com.datatech.dataskill.entities.dtos.request.SoftSkillDTORequest;
import com.datatech.dataskill.entities.dtos.response.SoftSkillDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="SoftSkillClient", url = "${spring.feign.url}")
public interface SoftSkillClient {

    @RequestMapping(method = RequestMethod.POST, value="/softskill/{userId}")
    void cadastrarSoftSkill(@PathVariable("userId") Long id, SoftSkillDTORequest request);

    @RequestMapping(method = RequestMethod.GET, value="/softskill/{userId}")
    List<SoftSkillDTOResponse> listarSoftSkill(@PathVariable("userId")Long id);
}
