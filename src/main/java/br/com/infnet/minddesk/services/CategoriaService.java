package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    void save(Categoria categoria);

    List<Categoria> findAll();

    Optional<Categoria> findById(Long id);

    Categoria update(Long id, Categoria categoriaAtualizada);

    void deleteById(Long id);
}
