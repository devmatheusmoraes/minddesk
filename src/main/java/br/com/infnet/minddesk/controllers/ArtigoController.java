package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.model.Agente;
import br.com.infnet.minddesk.model.Artigo;
import br.com.infnet.minddesk.services.impl.ArtigoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoServiceImpl artigoService;

    @PostMapping
    public ResponseEntity<Artigo> criarArtigo(@RequestBody Artigo artigo) {
        artigoService.save(artigo);
        return ResponseEntity.status(HttpStatus.CREATED).body(artigo);
    }

    @GetMapping
    public ResponseEntity<List<Artigo>> listarArtigos() {
        List<Artigo> artigos = artigoService.findAll();
        return ResponseEntity.ok(artigos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artigo> buscarArtigoPorId(@PathVariable Long id) {
        Optional<Artigo> artigoOptional = artigoService.findById(id);
        return artigoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artigo> atualizarArtigo(@PathVariable Long id, @RequestBody Artigo artigoAtualizado) {
        Optional<Artigo> artigoOptional = artigoService.findById(id);
        if (artigoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Artigo artigo = artigoOptional.get();
        Artigo artigoAtualizadoSalvo = artigoService.update(id, artigoAtualizado);
        return ResponseEntity.ok(artigoAtualizadoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarArtigo(@PathVariable Long id) {
        Optional<Artigo> artigoOptional = artigoService.findById(id);
        if (artigoOptional.isPresent()) {
            artigoService.deleteById(id);
            return ResponseEntity.ok("Artigo deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
