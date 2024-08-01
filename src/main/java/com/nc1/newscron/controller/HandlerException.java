package com.nc1.newscron.controller;

import com.nc1.newscron.exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * Global exception handler class for REST controllers.
 */
@RestControllerAdvice
public class HandlerException {

  private static final Logger log = LogManager.getLogger(HandlerException.class);
  private static final String ERROR_TEXT = "Oops! Something went wrong:( We're working to fix it! "
      + "Please try again later:)";

  /**
   * Handles bad request exceptions. Returns an HTTP status 400.
   *
   * @param exception The exception to be handled.
   * @return A String containing the error message from the exception.
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleNoFoundExceptions(Exception exception) {
    return handleException(HttpStatus.BAD_REQUEST, exception);
  }

  /**
   * Handles NoResourceFoundException. Returns an HTTP status 404.
   *
   * @param exception The exception to be handled.
   * @return A String containing the error message from the exception.
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<?> handleNoResourceFoundException(Exception exception) {
    return handleException(HttpStatus.NOT_FOUND, exception);
  }

  /**
   * Handles generic exceptions. Returns HTTP status 500.
   *
   * @param exception the exception to handle
   * @return ResponseEntity with error message
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleExceptionErrors(Exception exception) {
    return handleException(HttpStatus.INTERNAL_SERVER_ERROR, exception);
  }

  /**
   * Logs the exception and returns a ResponseEntity with the error message and status.
   *
   * @param status    the HTTP status to return
   * @param exception the exception to handle
   * @return ResponseEntity with error message
   */
  private ResponseEntity<?> handleException(HttpStatus status, Exception exception) {
    log.error("Handling Exception: {}", exception.getMessage(), exception);
    return ResponseEntity.status(status).body(ERROR_TEXT);
  }
}