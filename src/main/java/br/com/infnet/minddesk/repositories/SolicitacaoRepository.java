package br.com.infnet.minddesk.repositories;

import br.com.infnet.minddesk.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    @Query("SELECT COUNT(s) > 0 FROM Solicitacao s WHERE s.categoria.id = :categoriaId")
    boolean existsByCategoriaId(@Param("categoriaId") Long categoriaId);

    @Query("SELECT COUNT(s) > 0 FROM Solicitacao s WHERE s.agente.id = :agenteId")
    boolean existsByAgenteId(@Param("agenteId") Long agenteId);

    @Query("SELECT COUNT(s) > 0 FROM Solicitacao s WHERE s.cliente.id = :clienteId")
    boolean existsByClienteId(@Param("clienteId") Long clienteId);


}
