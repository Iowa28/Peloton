package ru.kpfu.peloton.pelotonproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "USER_NOT_FOUND")
public class UserNotFoundException extends RuntimeException{
}
