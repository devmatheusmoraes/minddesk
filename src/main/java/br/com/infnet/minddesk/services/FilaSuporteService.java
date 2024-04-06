package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.FilaSuporte;

import java.util.List;
import java.util.Optional;

public interface FilaSuporteService {

    void save(FilaSuporte filaSuporte);

    List<FilaSuporte> findAll();

    Optional<FilaSuporte> findById(Long id);

    FilaSuporte update(Long id, FilaSuporte filaSuporteAtualizada);

    void deleteById(Long id);
}
