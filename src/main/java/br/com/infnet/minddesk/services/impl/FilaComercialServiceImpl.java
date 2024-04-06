package br.com.infnet.minddesk.services.impl;

import br.com.infnet.minddesk.model.FilaComercial;
import br.com.infnet.minddesk.repositories.FilaComercialRepository;
import br.com.infnet.minddesk.services.FilaComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilaComercialServiceImpl implements FilaComercialService {

    @Autowired
    FilaComercialRepository filaComercialRepository;

    @Override
    public void save(FilaComercial filaComercial) {
        filaComercialRepository.save(filaComercial);
    }

    @Override
    public List<FilaComercial> findAll() {
        return filaComercialRepository.findAll();
    }

    @Override
    public Optional<FilaComercial> findById(Long id) {
        return filaComercialRepository.findById(id);
    }

    @Override
    public FilaComercial update(Long id, FilaComercial filaComercialAtualizada) {
        filaComercialAtualizada.setId(id);
        return filaComercialRepository.save(filaComercialAtualizada);
    }

    @Override
    public void deleteById(Long id) {
        filaComercialRepository.deleteById(id);
    }
}
