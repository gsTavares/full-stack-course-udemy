package com.gustavo.helpdesk.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gustavo.helpdesk.services.exceptions.ObjectNotFoundException;

@ControllerAdvice // Aplicado global para todas as controllers
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) // Manipulador de exceções do tipo ObjectNotFound
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex, 
    HttpServletRequest request) {

        StandardError error = new StandardError(
            System.currentTimeMillis(), 
            HttpStatus.NOT_FOUND.value(), 
            "Object not found", 
            ex.getMessage(), 
            request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}