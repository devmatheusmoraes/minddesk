package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.exception.CategoriaException;
import br.com.infnet.minddesk.model.Categoria;
import br.com.infnet.minddesk.services.impl.CategoriaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Categorias", description = " - Operações relacionadas a urgência do ticket")
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @Operation(summary = "Adicionar uma Nova Categoria")
    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaService.save(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        }catch (CategoriaException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Listagem de Categorias")
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        try {
            List<Categoria> categorias = categoriaService.findAll();
            return ResponseEntity.ok(categorias);
        }catch (CategoriaException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Exibir Categoria por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        return categoriaOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Editar Categoria por ID")
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

    @Operation(summary = "Excluir Categoria por ID")
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

