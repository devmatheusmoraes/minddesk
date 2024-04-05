package br.com.infnet.minddesk.exception;

public class SolicitacaoException extends RuntimeException {

    public SolicitacaoException(String message) {
        super(message);
    }

    public SolicitacaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
