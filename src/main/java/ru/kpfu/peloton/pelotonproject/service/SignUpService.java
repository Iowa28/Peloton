package ru.kpfu.peloton.pelotonproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.peloton.pelotonproject.dto.UserDto;
import ru.kpfu.peloton.pelotonproject.model.User;
import ru.kpfu.peloton.pelotonproject.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;

    public UserDto signUp(UserDto userDto) {
        //TODO:сохранение юзера в БД
        return null;
    }

    public boolean signIn(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

}
