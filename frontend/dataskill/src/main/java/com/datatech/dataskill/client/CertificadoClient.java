package com.datatech.dataskill.client;

import com.datatech.dataskill.entities.dtos.request.CertificadoDTORequest;
import com.datatech.dataskill.entities.dtos.response.CertificadoDTOResponse;
import com.datatech.dataskill.entities.dtos.response.ExperienciaDTOResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="CertificadoClient", url = "${spring.feign.url}")
public interface CertificadoClient {

    @RequestMapping(method = RequestMethod.POST, value="/certificado/{userId}")
    void cadastrarCertificado(@PathVariable("userId") Long id, CertificadoDTORequest request);

    @RequestMapping(method = RequestMethod.GET, value="/certificado/{userId}")
    List<CertificadoDTOResponse> listarCertificado(@PathVariable("userId")Long id);

    @RequestMapping(method = RequestMethod.DELETE, value="/certificado/{id}")
    void deletarCertificado(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.PUT, value="/certificado/{id}")
    void alterarCertificado (@PathVariable Long id, @RequestBody CertificadoDTOResponse request);

    @RequestMapping(method = RequestMethod.GET, value="/certificado/cert/{id}")
    CertificadoDTOResponse buscarPorId(@PathVariable Long id);
}


