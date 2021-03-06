package ru.kpfu.peloton.pelotonproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.peloton.pelotonproject.dto.WebinarDto;
import ru.kpfu.peloton.pelotonproject.service.WebinarService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class WebinarController {

    private final WebinarService webinarService;

    @GetMapping("/online_webinars")
    public String getOnlineWebinarsPage(ModelMap map) {
        map.addAttribute("webinars", webinarService.getActiveWebinars());
        return "online_webinars";
    }

    @GetMapping("/offline_webinars")
    public String getOfflineWebinarsPage(ModelMap map) {
        map.addAttribute("webinars", webinarService.getWebinarRecords());
        return "offline_webinars";
    }

    @GetMapping("/webinar_form")
    public String getWebinarForm(ModelMap map) {
        map.addAttribute("webinar", new WebinarDto());
        return "new_veb";
    }

    @PostMapping("/create_webinar")
    public String createWebinar(WebinarDto webinarDto) {
        webinarService.createWebinar(webinarDto);
        return "redirect:/online_webinars";
    }

    @PostMapping("/{id}/join_webinar")
    public String joinWebinar(@PathVariable("id") Long id, String email) {
        webinarService.addUserToWebinar(id, email);
        return "redirect:/";
    }
}
