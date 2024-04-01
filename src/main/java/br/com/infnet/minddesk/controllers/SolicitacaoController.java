package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.model.*;
import br.com.infnet.minddesk.services.impl.SolicitacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoServiceImpl solicitacaoService;

    @PostMapping
    public ResponseEntity<Solicitacao> criarSolicitacao(@RequestBody Solicitacao solicitacao) {
        // Criar um novo Agente com base nos dados fornecidos no JSON
        Agente agente = new Agente();
        agente.setId(solicitacao.getAgente().getId());
        agente.setNome(solicitacao.getAgente().getNome());
        agente.setEmail(solicitacao.getAgente().getEmail());
        agente.setCargo(solicitacao.getAgente().getCargo());

        // Criar uma nova Categoria com base nos dados fornecidos no JSON
        Categoria categoria = new Categoria();
        categoria.setNome(solicitacao.getCategoria().getNome());
        categoria.setId(solicitacao.getCategoria().getId());
        categoria.setDescricao(solicitacao.getCategoria().getDescricao());

        // Criar um novo Cliente com base nos dados fornecidos no JSON
        Cliente cliente = new Cliente();
        cliente.setNome(solicitacao.getCliente().getNome());
        cliente.setEmail(solicitacao.getCliente().getEmail());
        cliente.setTelefone(solicitacao.getCliente().getTelefone());
        cliente.setId(solicitacao.getCliente().getId());
        cliente.setSolicitacoes(solicitacao.getCliente().getSolicitacoes());

        // Definir os agentes, artigos, categoria e cliente na solicitação
        solicitacao.setAgente(agente);
        solicitacao.setCategoria(categoria);
        solicitacao.setCliente(cliente);

        // Salvar a solicitação com os dados atualizados
        solicitacaoService.save(solicitacao);

        // Retornar a solicitação criada com o status 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacao);
    }


    @GetMapping
    public ResponseEntity<List<Solicitacao>> listarSolicitacoes() {
        List<Solicitacao> solicitacoes = solicitacaoService.findAll();
        return ResponseEntity.ok(solicitacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> buscarSolicitacaoPorId(@PathVariable UUID id) {
        Optional<Solicitacao> solicitacaoOptional = solicitacaoService.findById(id);
        return solicitacaoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitacao> atualizarSolicitacao(@PathVariable UUID id, @RequestBody Solicitacao solicitacaoAtualizada) {
        Optional<Solicitacao> solicitacaoOptional = solicitacaoService.findById(id);
        if (solicitacaoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Solicitacao solicitacao = solicitacaoOptional.get();
        Solicitacao solicitacaoAtualizadaSalva = solicitacaoService.update(id, solicitacaoAtualizada);
        return ResponseEntity.ok(solicitacaoAtualizadaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSolicitacao(@PathVariable UUID id) {
        solicitacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
