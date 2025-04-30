package thiagorabaioli.Lostandfound.controllers.handlers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import thiagorabaioli.Lostandfound.DTO.CustomError;
import thiagorabaioli.Lostandfound.DTO.ValidationError;
import thiagorabaioli.Lostandfound.services.DataBaseException;
import thiagorabaioli.Lostandfound.services.exceptions.ResourceNotFoundException;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> customName(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<CustomError> integrity(DataBaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> validationErros(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        ValidationError err = new ValidationError(Instant.now(), status.value(), "validation erros @BeanValidation", request.getRequestURI());
        for (FieldError f : e.getBindingResult().getFieldErrors()){
            err.addErros(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }
}
