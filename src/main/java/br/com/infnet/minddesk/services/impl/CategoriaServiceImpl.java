package br.com.infnet.minddesk.services.impl;

import br.com.infnet.minddesk.model.Categoria;
import br.com.infnet.minddesk.repositories.CategoriaRepository;
import br.com.infnet.minddesk.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria update(Long id, Categoria categoriaAtualizada) {
        categoriaAtualizada.setId(id);
        return categoriaRepository.save(categoriaAtualizada);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
