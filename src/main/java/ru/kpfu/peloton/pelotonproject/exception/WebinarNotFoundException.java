package ru.kpfu.peloton.pelotonproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "WEBINAR_NOT_FOUND")
public class WebinarNotFoundException extends RuntimeException{
}
