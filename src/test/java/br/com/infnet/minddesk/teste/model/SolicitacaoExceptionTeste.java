package br.com.infnet.minddesk.teste.model;

import br.com.infnet.minddesk.exception.SolicitacaoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SolicitacaoExceptionTeste {
    @Test
    public void testSolicitacaoException() {
        assertThrows(SolicitacaoException.class, () -> {
            throw new SolicitacaoException("Erro ao processar a solicitação");
        });
    }

    @Test
    public void testSolicitacaoExceptionComMensagemECausa() {
        assertThrows(SolicitacaoException.class, () -> {
            throw new SolicitacaoException("Erro ao processar a solicitação", new RuntimeException("Causa do erro"));
        });
    }

}
