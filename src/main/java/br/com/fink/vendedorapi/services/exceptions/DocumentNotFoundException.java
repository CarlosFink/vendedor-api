package br.com.fink.vendedorapi.services.exceptions;

public class DocumentNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public DocumentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DocumentNotFoundException(String message) {
        super(message);
    }
}
