package ru.kpfu.peloton.pelotonproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.peloton.pelotonproject.dto.UserDto;
import ru.kpfu.peloton.pelotonproject.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void updateUser(Long userId, UserDto userDto) {
        //TODO:обновить юзера с валидацией по полям
    }

    @Override
    public UserDto getUser(Long userId) {
        //TODO:получить юзера
        return null;
    }
}
