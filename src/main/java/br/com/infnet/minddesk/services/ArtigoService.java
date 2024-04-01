package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.Artigo;

import java.util.List;
import java.util.Optional;

public interface ArtigoService {

    void save(Artigo artigo);

    List<Artigo> findAll();

    Optional<Artigo> findById(Long id);

    Artigo update(Long id, Artigo artigoAtualizado);

    void deleteById(Long id);
    
}
