package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.services.impl.AgenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.infnet.minddesk.model.Agente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/agentes")
public class AgenteController {

    @Autowired
    AgenteServiceImpl agenteService;

    @PostMapping
    public ResponseEntity<Agente> adicionarAgente(@RequestBody Agente agente) {
        agenteService.save(agente);
        return ResponseEntity.status(HttpStatus.CREATED).body(agente);
    }

    @GetMapping
    public ResponseEntity<List<Agente>> listarAgentes() {
        List<Agente> agentes = agenteService.findAll();
        return ResponseEntity.ok(agentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agente> buscarAgentePorId(@PathVariable Long id) {
        Optional<Agente> agenteOptional = agenteService.findById(id);
        return agenteOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirAgente(@PathVariable Long id) {
        Optional<Agente> agenteOptional = agenteService.findById(id);
        if (agenteOptional.isPresent()) {
            agenteService.deleteById(id);
            return ResponseEntity.ok("Agente deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
