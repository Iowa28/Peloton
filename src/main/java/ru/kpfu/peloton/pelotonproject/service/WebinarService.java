package ru.kpfu.peloton.pelotonproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.peloton.pelotonproject.dto.WebinarDto;
import ru.kpfu.peloton.pelotonproject.exception.UserNotFoundException;
import ru.kpfu.peloton.pelotonproject.exception.WebinarNotFoundException;
import ru.kpfu.peloton.pelotonproject.mapper.WebinarMapper;
import ru.kpfu.peloton.pelotonproject.model.User;
import ru.kpfu.peloton.pelotonproject.model.Webinar;
import ru.kpfu.peloton.pelotonproject.repository.UserRepository;
import ru.kpfu.peloton.pelotonproject.repository.WebinarRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WebinarService {

    private final WebinarRepository webinarRepository;
    private final UserRepository userRepository;

    public void createWebinar(WebinarDto webinarDto) {
        List<User> users = webinarDto.getUsers().stream()
                .map(userEmail -> userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new))
                .collect(Collectors.toList());
        Webinar webinar = Webinar.builder()
                .name(webinarDto.getName())
                .description(webinarDto.getDescription())
                .startDate(webinarDto.getStartDate())
                .endDate(webinarDto.getEndDate())
                .link(webinarDto.getLink())
                .users(users)
                .build();
        webinarRepository.save(webinar);
    }

    public List<WebinarDto> getActiveWebinars() {
        List<Webinar> webinars = webinarRepository.findAllByEndDateAfter(LocalDateTime.now());
        return WebinarMapper.convert(webinars);
    }

    public List<WebinarDto> getWebinarRecords() {
        List<Webinar> webinars = webinarRepository.findAllByEndDateBefore(LocalDateTime.now());
        return WebinarMapper.convert(webinars);
    }

    public void addUserToWebinar(Long id, String userEmail) {
        Webinar webinar = webinarRepository.findById(id).orElseThrow(WebinarNotFoundException::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new);
        webinar.getUsers().add(user);
        webinarRepository.save(webinar);
    }


}
