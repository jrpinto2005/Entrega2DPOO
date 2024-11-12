package exceptions;

public class ActivdadNoEcontradaException extends Exception {
    public ActivdadNoEcontradaException(String idActividad) {
        super("La actividad con ID " + idActividad + " no fue encontrada en el sistema.");
    }
}
