package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.*;
import br.com.infnet.minddesk.records.AgenteDTO;
import br.com.infnet.minddesk.records.ClienteDTO;
import br.com.infnet.minddesk.records.SolicitacaoDTO;
import br.com.infnet.minddesk.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DTOConverterService {

    @Autowired
    AgenteServiceImpl agenteService;

    @Autowired
    CategoriaServiceImpl categoriaService;

    @Autowired
    ClienteServiceImpl clienteService;

    @Autowired
    FilaComercialServiceImpl filaComercialService;

    @Autowired
    FilaSuporteServiceImpl filaSuporteService;

    @Autowired
    FilaProjetoServiceImpl filaProjetoService;

    public Solicitacao converterParaSolicitacaoDTO(SolicitacaoDTO solicitacaoDTO) {

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setTexto(solicitacaoDTO.texto());
        solicitacao.setUrgencia(solicitacaoDTO.urgencia());
        solicitacao.setDescricao(solicitacaoDTO.descricao());
        agenteService.findById(solicitacaoDTO.idAgente()).ifPresent(solicitacao::setAgente);
        categoriaService.findById(solicitacaoDTO.idCategoria()).ifPresent(solicitacao::setCategoria);
        clienteService.findById(solicitacaoDTO.idCliente()).ifPresent(solicitacao::setCliente);

        return solicitacao;
    }

    public Agente converterParaAgenteDTO(AgenteDTO dto){
        Agente agente = new Agente();
        agente.setId(dto.id());
        agente.setNome(dto.nome());
        agente.setEmail(dto.email());
        agente.setCargo(dto.cargo());

        return agente;
    }

    public Cliente converterParaClienteDTO(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setId(dto.id());
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());

        return cliente;
    }

}
