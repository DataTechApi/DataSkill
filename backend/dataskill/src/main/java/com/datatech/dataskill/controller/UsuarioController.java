package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@Tag(name = "usuario-controller")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Operation(summary = "Cria usuário para logar no sistema",
                description = "Cria o usuário somente com os dados necessários para o login do sistema")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"),@ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarUsuario(@RequestBody Usuario request){
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setCargo(request.getCargo());
        usuario.setSoft(request.getSoft());
        usuario.setHard(request.getHard());

       URI uri = URI.create("/usuario/"+usuario.getEmail());

        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.created(uri).build();
    }
    @GetMapping("/{email}")
    @Operation(summary = "Busca usuário por email", description = "Busca um usuário pelo email cadastrado")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"),@ApiResponse(responseCode = "404")})
    public ResponseEntity<Usuario> buscarPorEmail(@PathVariable String email){
        Optional<Usuario> usuario = usuarioService.buscarPorEmail(email);
        if(usuario.isPresent())
            return ResponseEntity.ok(usuario.get());
        else
            return ResponseEntity.notFound().build();
    }
    @GetMapping
    @Operation(summary="Busca todos os usuários no banco de dados", description = "Realiza a busca dos usários no banco de dados")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

}
