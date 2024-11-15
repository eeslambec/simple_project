package uz.tiue.project.exception;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String m) {
        super(m + " already exist");
    }
}
