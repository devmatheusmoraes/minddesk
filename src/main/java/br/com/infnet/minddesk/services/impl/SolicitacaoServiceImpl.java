package br.com.infnet.minddesk.services.impl;

import br.com.infnet.minddesk.model.Solicitacao;
import br.com.infnet.minddesk.repositories.SolicitacaoRepository;
import br.com.infnet.minddesk.services.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoServiceImpl implements SolicitacaoService {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    @Override
    public void save(Solicitacao solicitacao) {
        solicitacaoRepository.save(solicitacao);
    }

    @Override
    public List<Solicitacao> findAll() {
        return solicitacaoRepository.findAll();
    }

    @Override
    public Optional<Solicitacao> findById(Long id) {
        return solicitacaoRepository.findById(id);
    }

    @Override
    public Solicitacao update(Long id, Solicitacao solicitacaoAtualizada) {
        solicitacaoAtualizada.setId(id);
        return solicitacaoRepository.save(solicitacaoAtualizada);
    }

    @Override
    public void deleteById(Long id) {
        solicitacaoRepository.deleteById(id);
    }

    @Override
    public boolean existsByCategoriaId(Long categoriaId) {
        return solicitacaoRepository.existsByCategoriaId(categoriaId);
    }

    @Override
    public boolean existsByAgenteId(Long agenteId) {
        return solicitacaoRepository.existsByAgenteId(agenteId);
    }

    @Override
    public boolean existsByClienteId(Long clienteId) {
        return solicitacaoRepository.existsByClienteId(clienteId);
    }


}
