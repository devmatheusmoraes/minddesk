package br.com.infnet.minddesk.repositories;

import br.com.infnet.minddesk.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}
