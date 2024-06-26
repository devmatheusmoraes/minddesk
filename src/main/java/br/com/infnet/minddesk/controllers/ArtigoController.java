package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.exception.ArtigoException;
import br.com.infnet.minddesk.model.Artigo;
import br.com.infnet.minddesk.services.impl.ArtigoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Artigos", description = " - Operações relacionadas a base de conheimento para o time de suporte")
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoServiceImpl artigoService;

    @Operation(summary = "Adicionar um Novo Artigo")
    @PostMapping
    public ResponseEntity<Artigo> criarArtigo(@RequestBody Artigo artigo) {
        try {
            artigoService.save(artigo);
            return ResponseEntity.status(HttpStatus.CREATED).body(artigo);
        }catch (ArtigoException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Listagem de Artigos")
    @GetMapping
    public ResponseEntity<List<Artigo>> listarArtigos() {
        try {
            List<Artigo> artigos = artigoService.findAll();
            return ResponseEntity.ok(artigos);
        }catch (ArtigoException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Exibir Artigo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Artigo> buscarArtigoPorId(@PathVariable Long id) {
        Optional<Artigo> artigoOptional = artigoService.findById(id);
        return artigoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Editar Artigo por ID")
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

    @Operation(summary = "Excluir Artigo por ID")
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
