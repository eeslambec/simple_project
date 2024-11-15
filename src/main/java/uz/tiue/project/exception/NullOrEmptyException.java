package uz.tiue.project.exception;

public class NullOrEmptyException extends RuntimeException {
    public NullOrEmptyException(String m) {
        super(m + " is null or empty");
    }
}
