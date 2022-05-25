package ru.kpfu.peloton.pelotonproject.service;

import ru.kpfu.peloton.pelotonproject.dto.UserDto;

public interface UserService {
    void updateUser(Long userId, UserDto userDto);

    UserDto getUser(Long userId);
}
