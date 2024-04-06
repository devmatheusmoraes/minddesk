package br.com.infnet.minddesk.services.impl;

import br.com.infnet.minddesk.model.FilaProjeto;
import br.com.infnet.minddesk.repositories.FilaProjetoRepository;
import br.com.infnet.minddesk.services.FilaProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilaProjetoServiceImpl implements FilaProjetoService {

    @Autowired
    FilaProjetoRepository filaProjetoRepository;

    @Override
    public void save(FilaProjeto filaProjeto) {
        filaProjetoRepository.save(filaProjeto);
    }

    @Override
    public List<FilaProjeto> findAll() {
        return filaProjetoRepository.findAll();
    }

    @Override
    public Optional<FilaProjeto> findById(Long id) {
        return filaProjetoRepository.findById(id);
    }

    @Override
    public FilaProjeto update(Long id, FilaProjeto filaProjetoAtualizada) {
        filaProjetoAtualizada.setId(id);
        return filaProjetoRepository.save(filaProjetoAtualizada);
    }

    @Override
    public void deleteById(Long id) {
        filaProjetoRepository.deleteById(id);
    }
}
