package br.com.infnet.minddesk.teste.model;

import br.com.infnet.minddesk.exception.AgenteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AgenteExceptionTeste {

    @Test
    public void testAgenteException() {
        assertThrows(AgenteException.class, () -> {
            throw new AgenteException("Erro ao processar o agente");
        });
    }

    @Test
    public void testAgenteExceptionComMensagemECausa() {
        assertThrows(AgenteException.class, () -> {
            throw new AgenteException("Erro ao processar o agente", new RuntimeException("Causa do erro"));
        });
    }

}
