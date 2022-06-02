package ru.kpfu.peloton.pelotonproject.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class UserDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private LocalDate birthday;
    private LocalDate registrationDate;
    private Boolean isPremium;
    private Boolean isCoach;
    private String avatarUrl;
    private Double weight;
    private Double pulse;
    private Double height;
    private Double sysPressure;
    private Double diasPressure;
    private Integer slept;
    private List<String> webinars;
}
