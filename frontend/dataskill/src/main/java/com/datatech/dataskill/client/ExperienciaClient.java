package com.datatech.dataskill.client;

import com.datatech.dataskill.entities.dtos.request.ExperienciaDTORequest;
import com.datatech.dataskill.entities.dtos.response.ExperienciaDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="ExperienciaClient", url = "${spring.feign.url}")
public interface ExperienciaClient {

    @RequestMapping(method = RequestMethod.POST, value="/experiencia/{userId}")
    void cadastrarExperiencia(@PathVariable("userId") Long id, ExperienciaDTORequest request);

    @RequestMapping(method = RequestMethod.GET, value="/experiencia/{userId}")
    List<ExperienciaDTOResponse> listarExperiencia(@PathVariable("userId")Long id);

    @RequestMapping(method = RequestMethod.DELETE, value="/experiencia/{id}")
    void deletarExperiencia(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.PUT, value="/experiencia/{id}")
    void alterarExperiencia(@PathVariable Long id, @RequestBody ExperienciaDTOResponse request);

    @RequestMapping(method = RequestMethod.GET, value="/experiencia/exp/{id}")
    ExperienciaDTOResponse buscarPorId(@PathVariable Long id);
}
