package br.com.infnet.minddesk.services.impl;

import br.com.infnet.minddesk.model.Artigo;
import br.com.infnet.minddesk.repositories.ArtigoRepository;
import br.com.infnet.minddesk.services.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoServiceImpl implements ArtigoService {

    @Autowired
    ArtigoRepository artigoRepository;

    @Override
    public void save(Artigo artigo) {
        artigoRepository.save(artigo);
    }

    @Override
    public List<Artigo> findAll() {
        return artigoRepository.findAll();
    }

    @Override
    public Optional<Artigo> findById(Long id) {
        return artigoRepository.findById(id);
    }

    @Override
    public Artigo update(Long id, Artigo artigoAtualizado) {
        artigoAtualizado.setId(id);
        return artigoRepository.save(artigoAtualizado);
    }

    @Override
    public void deleteById(Long id) {
        artigoRepository.deleteById(id);
    }
}
