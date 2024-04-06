package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.exception.AgenteException;
import br.com.infnet.minddesk.records.AgenteDTO;
import br.com.infnet.minddesk.services.DTOConverterService;
import br.com.infnet.minddesk.services.impl.AgenteServiceImpl;
import br.com.infnet.minddesk.services.impl.SolicitacaoServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.infnet.minddesk.model.Agente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Tag(name = "Agentes", description = " - Operações relacionadas aos consultores do suporte")
@OpenAPIDefinition
@RequestMapping("/agentes")
public class AgenteController {

    @Autowired
    private AgenteServiceImpl agenteService;

    @Autowired
    private DTOConverterService dtoConverterService;

    @Autowired
    private SolicitacaoServiceImpl solicitacaoService;

    @Operation(summary = "Adicionar um Novo Agente")
    @PostMapping
    public ResponseEntity<Agente> adicionarAgente(@RequestBody AgenteDTO dto) {
        try {
            Agente agente = dtoConverterService.converterParaAgenteDTO(dto);
            agenteService.save(agente);
            return ResponseEntity.status(HttpStatus.CREATED).body(agente);
        }catch (AgenteException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Listagem de Agentes")
    @GetMapping
    public ResponseEntity<List<Agente>> listarAgentes() {
        try {
            List<Agente> agentes = agenteService.findAll();
            return ResponseEntity.ok(agentes);
        }catch (AgenteException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Exibir Agente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Agente> buscarAgentePorId(@PathVariable Long id) {
        try {
            Optional<Agente> agenteOptional = agenteService.findById(id);
            return agenteOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }catch (AgenteException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Editar Agente por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Agente> editarAgente(@PathVariable Long id, @RequestBody Agente agenteAtualizado) {
        Optional<Agente> agenteOptional = agenteService.findById(id);
        if (agenteOptional.isPresent()) {
            Agente agente = agenteService.update(id, agenteAtualizado);
            return ResponseEntity.ok(agente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Excluir Agente por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirAgente(@PathVariable Long id) {
        Optional<Agente> agenteOptional = agenteService.findById(id);
        if (agenteOptional.isPresent()) {
            if (!solicitacaoService.existsByAgenteId(id)) {
                agenteService.deleteById(id);
                return ResponseEntity.ok("Agente deletado com sucesso");
            }else {
                return ResponseEntity.ok("Existe pelo menos uma solicitação com este Agente");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
