package api.utfpr.projeto2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(DuplicateEntryException.class)
    private ResponseEntity<RestErrorMessage> duplicateEntryHandler(DuplicateEntryException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }

    @ExceptionHandler(StorageException.class)
    private ResponseEntity<RestErrorMessage> storageHandler(StorageException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(AlreadyExistsExeption.class)
    private ResponseEntity<RestErrorMessage> alreadyExistsHandler(AlreadyExistsExeption exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    private ResponseEntity<RestErrorMessage> storageFileNotFoundHandler(StorageFileNotFoundException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
