package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.LoginDTORequest;
import com.datatech.dataskill.entity.dto.response.LoginDTOResponse;
import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.service.LoginService;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
@CrossOrigin
@Tag(name = "login")
public class LoginController {

    private final LoginService loginService;
    private final ModelMapper modelMapper;
    private final UsuarioService usuarioService;

    public LoginController(LoginService loginService, ModelMapper modelMapper, UsuarioService usuarioService) {
        this.loginService = loginService;
        this.modelMapper = modelMapper;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Operation(summary = "Realiza o login com email e senha do usuário",
            description = "Realiza login passando o email e senha do usuário e retornando o status do login")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "401")})
    public ResponseEntity<LoginDTOResponse> realizarLogin(@RequestBody LoginDTORequest loginRequest) {
        if(loginService.realizarLogin(loginRequest)){
            Optional<Usuario> usuario = usuarioService.buscarPorEmail(loginRequest.email());
            LoginDTOResponse usuarioDTO = modelMapper.map(usuario, LoginDTOResponse.class);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }
}

