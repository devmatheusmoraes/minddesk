package br.com.infnet.minddesk.exception;

public class ArtigoException extends RuntimeException {

    public ArtigoException(String message) {
        super(message);
    }

    public ArtigoException(String message, Throwable cause) {
        super(message, cause);
    }
}
