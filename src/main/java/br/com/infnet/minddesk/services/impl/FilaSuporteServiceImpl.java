package br.com.infnet.minddesk.services.impl;

import br.com.infnet.minddesk.model.FilaSuporte;
import br.com.infnet.minddesk.repositories.FilaSuporteRepository;
import br.com.infnet.minddesk.services.FilaSuporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilaSuporteServiceImpl implements FilaSuporteService {

    @Autowired
    private FilaSuporteRepository filaSuporteRepository;

    @Override
    public void save(FilaSuporte filaSuporte) {
        filaSuporteRepository.save(filaSuporte);
    }

    @Override
    public List<FilaSuporte> findAll() {
        return filaSuporteRepository.findAll();
    }

    @Override
    public Optional<FilaSuporte> findById(Long id) {
        return filaSuporteRepository.findById(id);
    }

    @Override
    public FilaSuporte update(Long id, FilaSuporte filaSuporteAtualizada) {
        filaSuporteAtualizada.setId(id);
        return filaSuporteRepository.save(filaSuporteAtualizada);
    }

    @Override
    public void deleteById(Long id) {
        filaSuporteRepository.deleteById(id);
    }
}
