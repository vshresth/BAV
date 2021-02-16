package io.swagger.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;


public class CustomSwiftRefException extends RuntimeException {

    public CustomSwiftRefException(String s) {
        super (String.format("My Exception call error " + s));
    }
}


