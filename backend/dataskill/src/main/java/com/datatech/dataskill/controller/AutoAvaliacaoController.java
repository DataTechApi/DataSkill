
package com.datatech.dataskill.controller;

import com.datatech.dataskill.entity.model.AutoAvaliacao;
import com.datatech.dataskill.service.AutoAvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/autoAvaliacao")
@Tag(name = "autoavaliacao-controller")
public class AutoAvaliacaoController {
    private final AutoAvaliacaoService autoAvaliacaoService;

    public AutoAvaliacaoController(AutoAvaliacaoService autoAvaliacaoService) {
        this.autoAvaliacaoService = autoAvaliacaoService;
    }

    @PostMapping
    @Operation(summary = "Cria uma auto avaliação",
            description = "A autoavaliação de um sistema é o processo em que o próprio sistema analisa e mede seu " +
                    "desempenho, identificando pontos fortes e aspectos a melhorar")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "400")})
    public ResponseEntity<AutoAvaliacao> cadastrarAutoAvaliacao(@RequestBody AutoAvaliacao request) {
        AutoAvaliacao autoAvaliacao = new AutoAvaliacao();

        autoAvaliacao.setDescricao(request.getDescricao());
        autoAvaliacao.setDataAutoAvaliacao(request.getDataAutoAvaliacao());

        AutoAvaliacao salvarAutoAvaliacao = autoAvaliacaoService.cadastrarAutoAvaliacao(autoAvaliacao);
        return ResponseEntity.status(201).body(salvarAutoAvaliacao);

    }

    @GetMapping
    @Operation(summary = "Realiza a busca da autoavaliação",
            description = "Ferramenta que permite buscar todas as autoavaliações.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<List<AutoAvaliacao>> buscarAutoAvaliacao() {
        return ResponseEntity.ok(autoAvaliacaoService.buscarAutoAvaliacao());

    }

    @GetMapping("/{id}")
    @Operation(summary = "Realiza a busca da autoavaliação",
            description = "Ferramenta que permite buscar todas as autoavaliações.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<AutoAvaliacao> buscarIdAutoAvaliacao(@PathVariable Long id) {
        AutoAvaliacao autoAvaliacaoId = autoAvaliacaoService.buscarIdAutoAvaliacao(id);
        return ResponseEntity.ok(autoAvaliacaoId);
    }

    @DeleteMapping
    @Operation(summary = "Realiza a exclusão da autoavaliação",
            description = "Ferramenta que permite excluir uma das autoavaliações.")
    @ApiResponses(value = {@ApiResponse(responseCode = "204")})
    public ResponseEntity<AutoAvaliacao> deletarAutoAvaliacao(Long id) {
        autoAvaliacaoService.deletarAutoAvaliacao(id);
        return ResponseEntity.noContent().build();
    }

}
