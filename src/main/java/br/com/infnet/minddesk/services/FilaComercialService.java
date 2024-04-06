package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.FilaComercial;

import java.util.List;
import java.util.Optional;

public interface FilaComercialService {

    void save(FilaComercial filaComercial);

    List<FilaComercial> findAll();

    Optional<FilaComercial> findById(Long id);

    FilaComercial update(Long id, FilaComercial filaComercialAtualizada);

    void deleteById(Long id);
}
