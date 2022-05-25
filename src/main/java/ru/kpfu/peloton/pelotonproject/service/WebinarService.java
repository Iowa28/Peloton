package ru.kpfu.peloton.pelotonproject.service;

import ru.kpfu.peloton.pelotonproject.dto.WebinarDto;

import java.util.List;

public interface WebinarService {
    void createWebinar(WebinarDto webinarDto);

    List<WebinarDto> getActiveWebinars();

    List<WebinarDto> getWebinarRecords();

    String addUserToWebinar(String userEmail);
}
