package ru.kpfu.peloton.pelotonproject.service;

import org.springframework.stereotype.Service;
import ru.kpfu.peloton.pelotonproject.dto.UserDto;
import ru.kpfu.peloton.pelotonproject.model.User;
import ru.kpfu.peloton.pelotonproject.repository.UserRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;

    public SignUpServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto signUp(UserDto userDto) {
        //TODO:сохранение юзера в БД
        return null;
    }

    @Override
    public boolean signIn(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }
}
