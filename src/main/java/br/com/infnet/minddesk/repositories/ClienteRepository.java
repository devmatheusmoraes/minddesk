package br.com.infnet.minddesk.repositories;

import br.com.infnet.minddesk.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
