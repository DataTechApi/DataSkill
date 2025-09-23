package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.LoginDTORequest;
import com.datatech.dataskill.service.LoginService;
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

@RestController
@RequestMapping("/login")
@Tag(name = "login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping
    @Operation(summary = "Realiza p login com email e senha do usuário",
    description = "Realiza login passando o email e senha do usuário e retornando o status do login")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"),  @ApiResponse(responseCode = "401")})
    public ResponseEntity realizarLogin(@RequestBody LoginDTORequest loginRequest){
        if(loginService.realizarLogin(loginRequest)){
            return ResponseEntity.status(HttpStatus.OK).body("Login realizado com sucesso");
        }else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
}
