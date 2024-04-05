package br.com.infnet.minddesk.teste.model;

import br.com.infnet.minddesk.exception.ClienteException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteExceptionTeste {

    @Test
    public void testArtigoException() {
        assertThrows(ClienteException.class, () -> {
            throw new ClienteException("Erro ao processar o cliente");
        });
    }

    @Test
    public void testArtigoExceptionComMensagemECausa() {
        assertThrows(ClienteException.class, () -> {
            throw new ClienteException("Erro ao processar o cliente", new RuntimeException("Causa do erro"));
        });
    }

}
