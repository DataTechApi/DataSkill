package com.datatech.dataskill.client;

import com.datatech.dataskill.entities.dtos.request.HardSkillDTORequest;
import com.datatech.dataskill.entities.dtos.response.HardSkillDTOResponse;
import com.datatech.dataskill.entities.dtos.response.SoftSkillDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="HardSkillClient", url = "${spring.feign.url}")
public interface HardSkillClient {
    @RequestMapping(method = RequestMethod.POST, value="/hardskill/{userId}")
    void cadastrarHardSkill(@PathVariable("userId")Long id, HardSkillDTORequest request);

    @RequestMapping(method = RequestMethod.GET, value="/hardskill/{userId}")
    List<HardSkillDTOResponse> listarHardSkill(@PathVariable("userId")Long id);


}
