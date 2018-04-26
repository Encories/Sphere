package by.rubakhin.epam.task1.exceptions;

public class IncorrectUseOfParcerExcepcion extends Exception {
    public IncorrectUseOfParcerExcepcion() {
    }

    public IncorrectUseOfParcerExcepcion(String message) {
        super(message);
    }

    public IncorrectUseOfParcerExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectUseOfParcerExcepcion(Throwable cause) {
        super(cause);
    }
}
