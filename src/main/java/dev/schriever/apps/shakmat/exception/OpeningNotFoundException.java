package dev.schriever.apps.shakmat.exception;

public class OpeningNotFoundException extends RuntimeException {
  public OpeningNotFoundException(Long id) {
    super("Opening with id \"" + id + "\" is not found");
  }
}
