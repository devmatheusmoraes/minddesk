package br.com.infnet.minddesk.teste.model;

import br.com.infnet.minddesk.exception.CategoriaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CategoriaExceptionTeste {

    @Test
    public void testCategoriaException() {
        assertThrows(CategoriaException.class, () -> {
            throw new CategoriaException("Erro ao processar a categoria");
        });
    }

    @Test
    public void testCategoriaExceptionComMensagemECausa() {
        assertThrows(CategoriaException.class, () -> {
            throw new CategoriaException("Erro ao processar a categoria", new RuntimeException("Causa do erro"));
        });
    }

}
