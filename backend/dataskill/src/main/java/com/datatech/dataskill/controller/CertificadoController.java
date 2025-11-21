package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.CertificadoDTORequest;
import com.datatech.dataskill.entity.model.Certificado;
import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.service.CertificadoService;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/certificado")
@Tag(name = "certificado")
public class CertificadoController {

    private final CertificadoService certificadoService;
    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper;

    public CertificadoController(CertificadoService certificadoService, UsuarioService usuarioService, ModelMapper modelMapper) {
        this.certificadoService = certificadoService;
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/{userId}")
    @Operation(summary = "Cadastra um novo certificado", description = "Cadastra um novo certificado no banco de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Certificado criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar certificado")
    })
    public ResponseEntity cadastrar(@PathVariable Long userId, @RequestBody Certificado request) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(userId);
        if(usuario.isPresent()){
            Certificado certificado = modelMapper.map(request, Certificado.class);
            certificado.setUsuario(usuario.get());
            certificadoService.cadastrarCertificado(certificado);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/{userId}")
    @Operation(summary = "Lista todos os certificados por usuário",description = "Lista todos os certificados cadastrados no banco de dados")
    public ResponseEntity<List<Certificado>> listar(@PathVariable Long userId) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(userId);
        if(usuario.isPresent()){
            List<Certificado> certificados = certificadoService.listarCertificados(usuario.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(certificados);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um certificado existente",description = "Atualiza um certificado existente no banco de dados")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody CertificadoDTORequest request) {
        Optional<Certificado> certificado = certificadoService.buscarPorId(id);
        if(certificado.isPresent()){
            certificado.get().setNome(request.nome());
            certificado.get().setInstituicao(request.instituicao());
            certificado.get().setDataInicio(request.dataInicio());
            certificado.get().setDataFim(request.dataFim());
            certificadoService.atualizarCertificado(certificado.get());
            return ResponseEntity.status(HttpStatus.OK).body("Certificado alterado com sucesso!!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Certificado não encontrado!!");
        }

    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um certificado pelo ID",description = "Deleta um certificado pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        certificadoService.deletarCertificado(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/cert/{id}")
    public ResponseEntity<Optional<Certificado>> buscarCertificado(@PathVariable Long id){
        Optional<Certificado> certificado = certificadoService.buscarPorId(id);
        if (certificado.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(certificado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}