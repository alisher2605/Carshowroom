package kz.iitu.carshowroom.Exceptions;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Component
@Slf4j
public class GlobalExceptionController {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionData> handleNullPointerException(NullPointerException e) {
        log.error("Exception handled: "+ e.getMessage(), e);
        ExceptionData errorResponse = new ExceptionData("RuntimeException", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

   @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionData> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("Exception handled: "+ e.getMessage(), e);
       ExceptionData errorResponse = new ExceptionData("HttpRequestMethodNotSupportedException", "This URL doesn't exist");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionData> NotFoundException(NotFoundException e) {
        log.error("Exception handled: "+ e.getMessage(), e);
        ExceptionData errorResponse = new ExceptionData("NotFoundException", "Invalid URL");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //==============================
    //
    //==============================
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionData> handleAnyException(Exception e) {
        log.error("Exception handled: "+ e.getMessage(), e);
        ExceptionData errorResponse = new ExceptionData("INTERNAL_SERVER_ERROR",
                "Server down. Contact administrator to learn details" );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
