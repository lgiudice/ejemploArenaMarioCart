package org.uqbar.pdep.kart.excepciones;

@SuppressWarnings("all")
public class NoPuedeInscribirseException extends RuntimeException {
  public NoPuedeInscribirseException(final String message) {
    super(message);
  }
}
