
package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.dto.request.AutoAvaliacaoDTORequest;
import com.datatech.dataskill.entity.model.AutoAvaliacao;
import com.datatech.dataskill.entity.model.Usuario;
import com.datatech.dataskill.service.AutoAvaliacaoService;
import com.datatech.dataskill.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/autoavaliacao")
@Tag(name = "autoavaliacao")
public class AutoAvaliacaoController {
    private final AutoAvaliacaoService autoAvaliacaoService;
    private final ModelMapper modelMapper;
    private final UsuarioService usuarioService;

    public AutoAvaliacaoController(AutoAvaliacaoService autoAvaliacaoService, ModelMapper modelMapper, UsuarioService usuarioService) {
        this.autoAvaliacaoService = autoAvaliacaoService;
        this.modelMapper = modelMapper;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/{userId}")
    @Operation(summary = "Cria uma auto avaliação",
            description = "A autoavaliação de um sistema é o processo em que o próprio sistema analisa e mede seu " +
                    "desempenho, identificando pontos fortes e aspectos a melhorar")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "400")})
    public ResponseEntity cadastrarAutoAvaliacao(@PathVariable Long userId, @RequestBody AutoAvaliacaoDTORequest request) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(userId);
        if(usuario.isPresent()){
            AutoAvaliacao autoAvaliacao = modelMapper.map(request, AutoAvaliacao.class);
            autoAvaliacao.setUsuario(usuario.get());
            autoAvaliacaoService.cadastrarAutoAvaliacao(autoAvaliacao);
            return ResponseEntity.status(HttpStatus.CREATED).body(autoAvaliacao);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    @GetMapping
//    @Operation(summary = "Realiza a busca da autoavaliação",
//            description = "Ferramenta que permite buscar todas as autoavaliações.")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
//    public ResponseEntity<List<AutoAvaliacao>> buscarAutoAvaliacao() {
//        return ResponseEntity.ok(autoAvaliacaoService.buscarAutoAvaliacao());
//
//    }

    @GetMapping("/{userId}")
    @Operation(summary = "Realiza a busca da autoavaliação pelo ID",
            description = "Busca  autoavaliação pelo ID.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    public ResponseEntity<List<AutoAvaliacao>> buscarAutoAvaliacao(@PathVariable Long userId) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(userId);
        if (usuario.isPresent()) {
            List<AutoAvaliacao> autoAvaliacoes = autoAvaliacaoService.buscarAutoAvaliacao(usuario.get().getId());
            ;
            return ResponseEntity.status(HttpStatus.OK).body(autoAvaliacoes);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    @Operation(summary = "Realiza a exclusão da autoavaliação",
            description = "Ferramenta que permite excluir uma das autoavaliações.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"),@ApiResponse(responseCode = "404")})
    public ResponseEntity deletarAutoAvaliacao(Long id) {
        Optional<AutoAvaliacao> autoAvaliacao = autoAvaliacaoService.buscarAutoAvaliacaoId(id);
        if (autoAvaliacao.isPresent()){
            autoAvaliacaoService.deletarAutoAvaliacao(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
