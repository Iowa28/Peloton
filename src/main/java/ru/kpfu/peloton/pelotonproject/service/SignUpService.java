package ru.kpfu.peloton.pelotonproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.peloton.pelotonproject.dto.UserDto;
import ru.kpfu.peloton.pelotonproject.model.User;
import ru.kpfu.peloton.pelotonproject.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class SignUpService {

    public boolean signIn(String email, String password) {
        String testEmail = "aminovnf@list.ru";
        String testPassword = "qwerty007";
        return email.equals(testEmail) && password.equals(testPassword);
    }

}
