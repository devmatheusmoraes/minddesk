package br.com.infnet.minddesk.services.impl;

import br.com.infnet.minddesk.model.Agente;
import br.com.infnet.minddesk.repositories.AgenteRepository;
import br.com.infnet.minddesk.services.AgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenteServiceImpl implements AgenteService {

    @Autowired
    AgenteRepository agenteRepository;

    @Override
    public void save(Agente agente) {
        agenteRepository.save(agente);
    }

    @Override
    public List<Agente> findAll() {
        return agenteRepository.findAll();
    }

    @Override
    public Optional<Agente> findById(Long id) {
        return agenteRepository.findById(id);
    }

    @Override
    public Agente update(Long id, Agente agenteAtualizado) {
        agenteAtualizado.setId(id);
        return agenteRepository.save(agenteAtualizado);
    }

    @Override
    public void deleteById(Long id) {
        agenteRepository.deleteById(id);
    }
}
