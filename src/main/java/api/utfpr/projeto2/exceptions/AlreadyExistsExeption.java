package api.utfpr.projeto2.exceptions;

public class AlreadyExistsExeption extends RuntimeException{
    
    public AlreadyExistsExeption(String message) {
        super(message);
    }
}
