
package com.app.utilities.Exepcion;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 404 - Resource Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    // 400 - Bad Request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> badRequestException(MethodArgumentNotValidException ex, WebRequest request) {
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        return buildResponseEntity(HttpStatus.BAD_REQUEST, message, request);
    }

    // 401 - Unauthorized
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> unauthorizedException(UnauthorizedException ex, WebRequest request) {
        return buildResponseEntity(HttpStatus.UNAUTHORIZED, ex.getMessage(), request);
    }

    // 403 - Forbidden
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<?> forbiddenException(ForbiddenException ex, WebRequest request) {
        return buildResponseEntity(HttpStatus.FORBIDDEN, ex.getMessage(), request);
    }

    // 405 - Method Not Allowed
    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<?> methodNotAllowedException(MethodNotAllowedException ex, WebRequest request) {
        return buildResponseEntity(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage(), request);
    }

    // 500 - Internal Server Error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request);
    }

    // Método para construir la respuesta
    private ResponseEntity<?> buildResponseEntity(HttpStatus status, String message, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        body.put("path", request.getDescription(false));

        return new ResponseEntity<>(body, status);
    }
}


