package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.FilaProjeto;

import java.util.List;
import java.util.Optional;

public interface FilaProjetoService {

    void save(FilaProjeto filaProjeto);

    List<FilaProjeto> findAll();

    Optional<FilaProjeto> findById(Long id);

    FilaProjeto update(Long id, FilaProjeto filaProjetoAtualizada);

    void deleteById(Long id);
}
