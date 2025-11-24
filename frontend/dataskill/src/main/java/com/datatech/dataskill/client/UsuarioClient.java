package com.datatech.dataskill.client;

import com.datatech.dataskill.entities.dtos.request.UsuarioDTORequest;
import com.datatech.dataskill.entities.dtos.response.UsuarioDTOResponse;
import com.datatech.dataskill.entities.dtos.response.UsuarioPerfilDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="UsuarioClient", url = "${spring.feign.url}")
public interface UsuarioClient {
    @RequestMapping(method= RequestMethod.POST, value="/usuario")
    void cadastrarUsuario(@RequestBody UsuarioDTORequest request);

    @RequestMapping(method = RequestMethod.GET, value="/usuario/{id}")
    UsuarioDTOResponse buscarUsuarioId(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.DELETE, value="/usuario/{id}")
    void deletarUsuario(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.PUT, value="/usuario/{id}")
    void alterarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioDTOResponse request);

    @RequestMapping(method= RequestMethod.GET, value="/usuario/perfil/{id}")
    UsuarioPerfilDTO buscarPerfilId(@PathVariable Long id);

    @RequestMapping(method= RequestMethod.GET, value="/usuario/hard/{skill}")
    List<UsuarioDTOResponse> buscarUsuarioHard(@PathVariable String skill);

}
