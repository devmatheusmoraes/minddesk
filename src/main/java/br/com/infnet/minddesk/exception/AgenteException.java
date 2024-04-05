package br.com.infnet.minddesk.exception;

public class AgenteException extends RuntimeException {

    public AgenteException(String message) {
        super(message);
    }

    public AgenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
