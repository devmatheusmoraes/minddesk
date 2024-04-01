package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.Agente;

import java.util.List;
import java.util.Optional;

public interface AgenteService {

    void save(Agente agente);

    List<Agente> findAll();

    Optional<Agente> findById(Long id);

    Agente update(Long id, Agente agenteAtualizado);

    void deleteById(Long id);
}
