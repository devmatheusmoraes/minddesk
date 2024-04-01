package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.model.Artigo;
import br.com.infnet.minddesk.model.Categoria;
import br.com.infnet.minddesk.services.impl.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        return categoriaOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaAtualizada) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if (categoriaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Categoria categoria = categoriaOptional.get();
        Categoria categoriaAtualizadaSalva = categoriaService.update(id, categoriaAtualizada);
        return ResponseEntity.ok(categoriaAtualizadaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if (categoriaOptional.isPresent()) {
            categoriaService.deleteById(id);
            return ResponseEntity.ok("Categoria deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

