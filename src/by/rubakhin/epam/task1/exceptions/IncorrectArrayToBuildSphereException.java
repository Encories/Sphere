package by.rubakhin.epam.task1.exceptions;

public class IncorrectArrayToBuildSphereException extends Exception {
    public IncorrectArrayToBuildSphereException() {
        super();
    }

    public IncorrectArrayToBuildSphereException(String message) {
        super(message);
    }

    public IncorrectArrayToBuildSphereException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectArrayToBuildSphereException(Throwable cause) {
        super(cause);
    }
}