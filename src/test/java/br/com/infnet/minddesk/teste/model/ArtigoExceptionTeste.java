package br.com.infnet.minddesk.teste.model;

import br.com.infnet.minddesk.exception.ArtigoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArtigoExceptionTeste {

    @Test
    public void testArtigoException() {
        assertThrows(ArtigoException.class, () -> {
            throw new ArtigoException("Erro ao processar o artigo");
        });
    }

    @Test
    public void testArtigoExceptionComMensagemECausa() {
        assertThrows(ArtigoException.class, () -> {
            throw new ArtigoException("Erro ao processar o artigo", new RuntimeException("Causa do erro"));
        });
    }

}
