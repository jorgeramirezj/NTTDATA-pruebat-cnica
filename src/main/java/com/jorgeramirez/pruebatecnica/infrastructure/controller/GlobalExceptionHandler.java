package com.jorgeramirez.pruebatecnica.infrastructure.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jorgeramirez.pruebatecnica.domain.exception.InternalServerErrorException;
import com.jorgeramirez.pruebatecnica.domain.exception.InvalidArgumentException;
import com.jorgeramirez.pruebatecnica.domain.exception.UsuarioNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity<String> handleInternalServerError(
      InternalServerErrorException ex) {

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Error interno del servidor: "
            + ex.getMessage());
  }

  @ExceptionHandler(UsuarioNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleUsuarioNotFound(
      UsuarioNotFoundException ex) {

    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("timestamp", LocalDateTime.now());
    errorResponse.put("status", HttpStatus.NOT_FOUND.value());
    errorResponse.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
    errorResponse.put("message", ex.getMessage());

    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InvalidArgumentException.class)
  public ResponseEntity<Map<String, Object>> handleInvalidArgument(
      InvalidArgumentException ex) {

    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("timestamp", LocalDateTime.now());
    errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
    errorResponse.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
    errorResponse.put("message", ex.getMessage());

    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Map<String, Object>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {

    Map<String, Object> response = new HashMap<>();
    response.put("status", HttpStatus.BAD_REQUEST.value());
    response.put("error", "Bad Request");
    response.put("message", "Validación fallida");
    response.put("timestamp", System.currentTimeMillis());

    Map<String, String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .collect(Collectors.toMap(FieldError::getField,
            FieldError::getDefaultMessage));

    response.put("errors", errors);

    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleGenericException(
      Exception ex) {

    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("timestamp", LocalDateTime.now());
    errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    errorResponse.put("error",
        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    errorResponse.put("message", ex.getMessage());

    return new ResponseEntity<>(errorResponse,
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
