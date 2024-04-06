package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.exception.SolicitacaoException;
import br.com.infnet.minddesk.model.*;
import br.com.infnet.minddesk.records.SolicitacaoDTO;
import br.com.infnet.minddesk.services.DTOConverterService;
import br.com.infnet.minddesk.services.impl.SolicitacaoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Solicitacoes", description = " - Operações relacionadas a tickets de suporte")
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoServiceImpl solicitacaoService;

    @Autowired
    private DTOConverterService dtoConverterService;

    @Operation(summary = "Adicionar uma Nova Solicitação")
    @PostMapping
    public ResponseEntity<Solicitacao> criarSolicitacao(@RequestBody SolicitacaoDTO dto) {
        try {
            Solicitacao solicitacao = dtoConverterService.converterParaSolicitacaoDTO(dto);
            solicitacaoService.save(solicitacao);
            return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
        }catch (SolicitacaoException e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Listagem de Solicitações")
    @GetMapping
    public ResponseEntity<List<Solicitacao>> listarSolicitacoes() {
        try {
            List<Solicitacao> solicitacoes = solicitacaoService.findAll();
            return ResponseEntity.ok(solicitacoes);
        }catch (SolicitacaoException e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Exibir Solicitação por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> buscarSolicitacaoPorId(@PathVariable Long id) {
        Optional<Solicitacao> solicitacaoOptional = solicitacaoService.findById(id);
        return solicitacaoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Editar Solicitação por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Solicitacao> atualizarSolicitacao(@PathVariable Long id, @RequestBody Solicitacao solicitacaoAtualizada) {
        Optional<Solicitacao> solicitacaoOptional = solicitacaoService.findById(id);
        if (solicitacaoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Solicitacao solicitacao = solicitacaoOptional.get();
        Solicitacao solicitacaoAtualizadaSalva = solicitacaoService.update(id, solicitacaoAtualizada);
        return ResponseEntity.ok(solicitacaoAtualizadaSalva);
    }

    @Operation(summary = "Excluir Solicitação por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarSolicitacao(@PathVariable Long id) {
        Optional<Solicitacao> solicitacaoOptional = solicitacaoService.findById(id);
        if (solicitacaoOptional.isPresent()) {
            solicitacaoService.deleteById(id);
            return ResponseEntity.ok("Solicitação deletada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
