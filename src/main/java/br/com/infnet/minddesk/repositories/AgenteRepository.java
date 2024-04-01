package br.com.infnet.minddesk.repositories;

import br.com.infnet.minddesk.model.Agente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteRepository extends JpaRepository<Agente, Long> {
}
