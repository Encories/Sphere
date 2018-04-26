package by.rubakhin.epam.task1.exceptions;


public class IncorrectRadiusOfSphereException extends Exception {
    public IncorrectRadiusOfSphereException() {
        super();
    }

    public IncorrectRadiusOfSphereException(String message) {
        super(message);
    }

    public IncorrectRadiusOfSphereException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectRadiusOfSphereException(Throwable cause) {
        super(cause);
    }
}
