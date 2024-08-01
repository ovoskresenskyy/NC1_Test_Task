package com.nc1.newscron.exception;

/**
 * Exception thrown when child object are not found.
 */
public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
