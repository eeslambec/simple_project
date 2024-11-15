package uz.tiue.project.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String m) {
        super(m + " not found");
    }
}
