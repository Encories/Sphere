package by.rubakhin.epam.task1.exceptions;


public class SphereException extends Exception {
    private String detail;

    public SphereException(String detail) {
        this.detail = detail;
    }

    public SphereException(String message, String detail) {
        super(message);
        this.detail = detail;
    }

    public SphereException(String message, Throwable cause, String detail) {
        super(message, cause);
        this.detail = detail;
    }

    public SphereException(Throwable cause, String detail) {
        super(cause);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "SphereException{" +
                "detail='" + detail + '\'' +
                '}';
    }

}
