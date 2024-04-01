package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.Solicitacao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SolicitacaoService {

    void save(Solicitacao solicitacao);

    List<Solicitacao> findAll();

    Optional<Solicitacao> findById(UUID id);

    Solicitacao update(UUID id, Solicitacao solicitacaoAtualizada);

    void deleteById(UUID id);
}
