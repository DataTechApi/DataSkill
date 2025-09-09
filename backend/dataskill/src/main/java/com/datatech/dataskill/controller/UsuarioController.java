package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/usuario")
@Tag(name = "usuariocontroller")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Operation(summary = "Cria usuário para logar no sistema",
                description = "Cria o usuário somente com os dados necessários par a login o sistema")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"),@ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarUsuario(@RequestBody Usuario request){
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setCargo(request.getCargo());
        usuario.setSoft(request.getSoft());
        usuario.setHard(request.getHard());

        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok().build();

    }
}
