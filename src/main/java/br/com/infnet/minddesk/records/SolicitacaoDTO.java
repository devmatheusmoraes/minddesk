package br.com.infnet.minddesk.records;

public record SolicitacaoDTO(Long id, Long idAgente, Long idCategoria, Long idCliente, String descricao, String urgencia, String texto) {
}
