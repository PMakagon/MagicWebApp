package ru.hogwards.school.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WrongKeyException extends RuntimeException{
    public WrongKeyException(String message) {
        super(message);
    }
}
