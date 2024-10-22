package api.utfpr.projeto2.exceptions;

public class DuplicateEntryException extends RuntimeException{
    
    public DuplicateEntryException(String message){
        super(message);
    }
}
