package ubb.movierentals.ClientEntity.exception;

public class DataBaseOperationException extends RuntimeException {
    public DataBaseOperationException(String message) {
        super(message);
    }
}
