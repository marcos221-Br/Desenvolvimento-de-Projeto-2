package api.utfpr.projeto2.exceptions;

public class UnauthorizedException extends RuntimeException{
    
    public UnauthorizedException(String message){
        super(message);
    }
}
