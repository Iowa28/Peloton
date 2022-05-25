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
    private boolean isPremium;
    private boolean isCoach;
    private String avatarUrl;
    private double weight;
    private double pulse;
    private double height;
    private double sysPressure;
    private double diasPressure;
    private int slept;
    private List<String> webinars;
}
