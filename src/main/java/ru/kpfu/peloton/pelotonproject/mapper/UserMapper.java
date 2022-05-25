package ru.kpfu.peloton.pelotonproject.mapper;

import ru.kpfu.peloton.pelotonproject.dto.UserDto;
import ru.kpfu.peloton.pelotonproject.model.User;
import ru.kpfu.peloton.pelotonproject.model.Webinar;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static List<UserDto> convert(List<User> users) {
        return users.stream().map(UserMapper::convert).collect(Collectors.toList());
    }

    public static UserDto convert(User user) {
        return UserDto.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .birthday(user.getUserInfo().getBirthday())
                .registrationDate(user.getUserInfo().getRegistrationDate())
                .isPremium(user.getUserInfo().isPremium())
                .isCoach(user.getUserInfo().isCoach())
                .avatarUrl(user.getUserInfo().getAvatarUrl())
                .weight(user.getUserCharacteristics().getWeight())
                .pulse(user.getUserCharacteristics().getPulse())
                .height(user.getUserCharacteristics().getHeight())
                .sysPressure(user.getUserCharacteristics().getSysPressure())
                .diasPressure(user.getUserCharacteristics().getDiasPressure())
                .slept(user.getUserCharacteristics().getSlept())
                .webinars(user.getWebinars().stream().map(Webinar::getName).collect(Collectors.toList()))
                .build();
    }
}
