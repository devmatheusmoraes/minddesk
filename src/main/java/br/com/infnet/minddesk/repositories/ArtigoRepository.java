package br.com.infnet.minddesk.repositories;

import br.com.infnet.minddesk.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
}
