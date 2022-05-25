package ru.kpfu.peloton.pelotonproject.service;

import ru.kpfu.peloton.pelotonproject.dto.UserDto;

public interface SignUpService {
    UserDto signUp(UserDto userDto);

    boolean signIn(String email, String password);
}
