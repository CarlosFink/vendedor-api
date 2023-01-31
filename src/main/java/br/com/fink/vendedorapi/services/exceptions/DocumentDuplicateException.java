package br.com.fink.vendedorapi.services.exceptions;

public class DocumentDuplicateException extends RuntimeException {
	    
		private static final long serialVersionUID = 1L;

		public DocumentDuplicateException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public DocumentDuplicateException(String message) {
	        super(message);
	    }
}
