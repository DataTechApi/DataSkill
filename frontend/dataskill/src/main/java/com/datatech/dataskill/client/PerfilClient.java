package com.datatech.dataskill.client;

import com.datatech.dataskill.entities.dtos.response.UsuarioPerfilDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="PerfilClient", url = "${spring.feign.url}")
public interface PerfilClient {

    @RequestMapping(method = RequestMethod.GET, value = "/usuario/{id}")
    UsuarioPerfilDTO getById(@PathVariable("id") Long Id);
}
