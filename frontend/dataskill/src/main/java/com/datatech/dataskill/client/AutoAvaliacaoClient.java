package com.datatech.dataskill.client;

import com.datatech.dataskill.entities.dtos.request.AutoAvaliacaoDTORequest;
import com.datatech.dataskill.entities.dtos.request.CertificadoDTORequest;
import com.datatech.dataskill.entities.dtos.response.AutoAvaliacaoDTOResponse;
import com.datatech.dataskill.entities.dtos.response.CertificadoDTOResponse;
import com.datatech.dataskill.entities.dtos.response.ExperienciaDTOResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="AutoAvaliacaoClient", url = "${spring.feign.url}")
public interface AutoAvaliacaoClient {
    @RequestMapping(method = RequestMethod.POST, value="/autoavaliacao/{userId}")
    void cadastrarAutoAvaliacao(@PathVariable("userId") Long id, AutoAvaliacaoDTORequest request);

    @RequestMapping(method = RequestMethod.GET, value="/autoavaliacao/{userId}")
    List<AutoAvaliacaoDTOResponse> listarAutoAvaliacao(@PathVariable("userId")Long id);

     @RequestMapping(method = RequestMethod.DELETE, value="/autoavaliacao/{id}")
    void deletarAutoAvalicao(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.PUT, value="/autoavaliacao/{id}")
    void alterarAutoAvaliacao(@PathVariable Long id, @RequestBody AutoAvaliacaoDTOResponse request);

    @RequestMapping(method = RequestMethod.GET, value="/autoavaliacao/auto/{id}")
    AutoAvaliacaoDTOResponse buscarPorId(@PathVariable Long id);


}
