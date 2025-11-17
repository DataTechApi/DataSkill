package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.UsuarioDTORequest;
import com.datatech.dataskill.entity.dto.response.UsuarioDTOResponse;
import com.datatech.dataskill.entity.dto.response.UsuarioPerfilDTOResponse;
import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
@Tag(name = "usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final ModelMapper modelMapper;

    public UsuarioController(UsuarioService usuarioService, ModelMapper modelMapper) {
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @Operation(summary = "Cria usuário para logar no sistema",
                description = "Cria o usuário somente com os dados necessários para o login do sistema")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"),@ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarUsuario(@RequestBody UsuarioDTORequest request){
        Usuario usuario = modelMapper.map(request, Usuario.class);
         usuarioService.cadastrarUsuario(usuario);
        URI uri = URI.create(STR."/usuario/\{usuario.getEmail()}");
        return ResponseEntity.created(uri).build();
    }
//    @GetMapping("/{email}")
//    @Operation(summary = "Busca usuário por email", description = "Busca um usuário pelo email cadastrado")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200"),@ApiResponse(responseCode = "404")})
//    public ResponseEntity<Usuario> buscarPorEmail(@PathVariable String email){
//        Optional<Usuario> usuario = usuarioService.buscarPorEmail(email);
//        if(usuario.isPresent())
//            return ResponseEntity.ok(usuario.get());
//        else
//            return ResponseEntity.notFound().build();
//    }
    @GetMapping
    @Operation(summary="Busca todos os usuários no banco de dados", description = "Realiza a busca dos usuários no banco de dados")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<Iterable<UsuarioDTOResponse>> listarUsuarios(){
        Iterable<Usuario> usuarios = usuarioService.listarUsuarios();
        Iterable<UsuarioDTOResponse> usuarioDTO = modelMapper.map(usuarios, new TypeToken<List<UsuarioDTOResponse>>(){}.getType());
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioPerfilDTOResponse> buscarPorId(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        if(usuario.isPresent()){
           UsuarioPerfilDTOResponse perfilDTO = modelMapper.map(usuario.get(), UsuarioPerfilDTOResponse.class);
            return ResponseEntity.ok((perfilDTO));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
