package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.Agente;
import br.com.infnet.minddesk.model.Categoria;
import br.com.infnet.minddesk.model.Cliente;
import br.com.infnet.minddesk.model.Solicitacao;
import org.springframework.stereotype.Service;

@Service
public class DTOConverterService {

    public Solicitacao converterParaSolicitacaoDTO(Solicitacao solicitacaoDTO) {
        Solicitacao solicitacao = new Solicitacao();
        Agente agente = new Agente();
        agente.setId(solicitacaoDTO.getAgente().getId());
        agente.setNome(solicitacaoDTO.getAgente().getNome());
        agente.setEmail(solicitacaoDTO.getAgente().getEmail());
        agente.setCargo(solicitacaoDTO.getAgente().getCargo());

        Categoria categoria = new Categoria();
        categoria.setId(solicitacaoDTO.getCategoria().getId());
        categoria.setNome(solicitacaoDTO.getCategoria().getNome());
        categoria.setDescricao(solicitacaoDTO.getCategoria().getDescricao());

        Cliente cliente = new Cliente();
        cliente.setId(solicitacaoDTO.getCliente().getId());
        cliente.setNome(solicitacaoDTO.getCliente().getNome());
        cliente.setEmail(solicitacaoDTO.getCliente().getEmail());
        cliente.setTelefone(solicitacaoDTO.getCliente().getTelefone());

        solicitacao.setTexto(solicitacaoDTO.getTexto());
        solicitacao.setUrgencia(solicitacaoDTO.getUrgencia());
        solicitacao.setDescricao(solicitacaoDTO.getDescricao());
        solicitacao.setEmail(solicitacaoDTO.getEmail());
        solicitacao.setAgente(agente);
        solicitacao.setCategoria(categoria);
        solicitacao.setCliente(cliente);

        return solicitacao;
    }
}
