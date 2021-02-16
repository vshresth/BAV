package io.swagger.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({CustomErrorException.class})
    public ResponseEntity<ErrorResponse> exceptionToDoHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept", "application/json");
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage("Unable to process request");
        return new ResponseEntity<ErrorResponse>(error, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept", "application/json");
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage("The request could not be understood by the server due to malformed syntax.");
        return new ResponseEntity<ErrorResponse>(error, headers, HttpStatus.BAD_REQUEST);
    }

}
