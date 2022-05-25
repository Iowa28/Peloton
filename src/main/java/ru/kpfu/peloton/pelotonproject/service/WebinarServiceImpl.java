package ru.kpfu.peloton.pelotonproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.peloton.pelotonproject.dto.WebinarDto;
import ru.kpfu.peloton.pelotonproject.repository.UserRepository;
import ru.kpfu.peloton.pelotonproject.repository.WebinarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebinarServiceImpl implements WebinarService {

    private final WebinarRepository webinarRepository;
    private final UserRepository userRepository;

    @Override
    public void createWebinar(WebinarDto webinarDto) {
        //TODO:сохранить вебинар в БД
    }

    @Override
    public List<WebinarDto> getActiveWebinars() {
        //TODO:получить активные вебинары из БД
        return null;
    }

    @Override
    public List<WebinarDto> getWebinarRecords() {
        //TODO:получить неактивные вебинары из БД
        return null;
    }

    @Override
    public String addUserToWebinar(String userEmail) {
        //TODO:добавить пользователя в вебинар и вернуть ссылку на вебинар
        return null;
    }


}
