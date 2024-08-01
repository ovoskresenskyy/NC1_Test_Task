package com.nc1.newscron.exception;

/**
 * Exception thrown when news is not found by ID.
 */
public class NewsNotFoundException extends RuntimeException {

  private static final String MESSAGE_NOT_FOUND = "News with id %d not found.";

  public NewsNotFoundException(long id) {
    super(String.format(MESSAGE_NOT_FOUND, id));
  }
}
