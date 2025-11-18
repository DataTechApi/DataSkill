package com.datatech.dataskill.client;

import com.datatech.dataskill.entities.dtos.request.HardSkillDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="HardSkillClient", url = "${spring.feign.url}")
public interface HardSkillClient {
    @RequestMapping(method = RequestMethod.POST, value="/hardskill/{userId}")
    void cadastrarHardSkill(HardSkillDTORequest request);


}
