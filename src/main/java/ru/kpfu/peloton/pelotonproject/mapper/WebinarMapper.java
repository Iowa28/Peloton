package ru.kpfu.peloton.pelotonproject.mapper;

import ru.kpfu.peloton.pelotonproject.dto.WebinarDto;
import ru.kpfu.peloton.pelotonproject.model.User;
import ru.kpfu.peloton.pelotonproject.model.Webinar;

import java.util.List;
import java.util.stream.Collectors;

public class WebinarMapper {

    public static List<WebinarDto> convert(List<Webinar> webinars) {
        return webinars.stream().map(WebinarMapper::convert).collect(Collectors.toList());
    }

    public static WebinarDto convert(Webinar webinar) {
        return WebinarDto.builder()
                .name(webinar.getName())
                .description(webinar.getDescription())
                .startDate(webinar.getStartDate())
                .endDate(webinar.getEndDate())
                .link(webinar.getLink())
                .users(webinar.getUsers().stream().map(User::getEmail).collect(Collectors.toList()))
                .build();
    }
}
