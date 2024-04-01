package br.com.infnet.minddesk.repositories;

import br.com.infnet.minddesk.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
