package br.com.fink.vendedorapi.exceptions;

import java.time.LocalDateTime;

import javax.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import br.com.fink.vendedorapi.services.exceptions.DocumentDuplicateException;
import br.com.fink.vendedorapi.services.exceptions.DocumentNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(DocumentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDetails> documentNotFoundException(DocumentNotFoundException e, ServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails().builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .details("")
                .developerMessage(e.getClass().getName())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DocumentDuplicateException.class)
    public ResponseEntity<ErrorDetails> documentDuplicateException(DocumentDuplicateException e,
            ServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails().builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .details("")
                .developerMessage(e.getClass().getName())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException e,
            ServletRequest request) {     
        ValidationErrorDetails errorDetails = new ValidationErrorDetails(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Erro na validação dos campos", e.getMessage(), e.getClass().getName());
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errorDetails.addErrors(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }  
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorDetails> methodArgumentNotValidException(HttpClientErrorException e,
            ServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails().builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .details("")
                .developerMessage(e.getClass().getName())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    } 
    
}
