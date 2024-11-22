package api.utfpr.projeto2.exceptions;

public class AlreadyExistsException extends RuntimeException{
    
    public AlreadyExistsException(String message) {
        super(message);
    }
}
