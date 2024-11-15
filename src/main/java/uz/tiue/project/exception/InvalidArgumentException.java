package uz.tiue.project.exception;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String m) {
        super(m + " is not a valid argument");
    }
}
