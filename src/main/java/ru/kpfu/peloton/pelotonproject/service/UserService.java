package ru.kpfu.peloton.pelotonproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import ru.kpfu.peloton.pelotonproject.dto.UserDto;
import ru.kpfu.peloton.pelotonproject.exception.UserNotFoundException;
import ru.kpfu.peloton.pelotonproject.exception.WebinarNotFoundException;
import ru.kpfu.peloton.pelotonproject.mapper.UserMapper;
import ru.kpfu.peloton.pelotonproject.model.User;
import ru.kpfu.peloton.pelotonproject.model.Webinar;
import ru.kpfu.peloton.pelotonproject.repository.UserRepository;
import ru.kpfu.peloton.pelotonproject.repository.WebinarRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final WebinarRepository webinarRepository;

    public void updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        if (StringUtils.isEmpty(userDto.getFirstname())) {
            user.setFirstname(userDto.getFirstname());
        }
        if (StringUtils.isEmpty(userDto.getLastname())) {
            user.setLastname(userDto.getLastname());
        }
        if (StringUtils.isEmpty(userDto.getEmail())) {
            user.setEmail(userDto.getEmail());
        }
        if (StringUtils.isEmpty(userDto.getPassword())) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        if (userDto.getBirthday() != null) {
            user.getUserInfo().setBirthday(userDto.getBirthday());
        }
        if (userDto.getRegistrationDate() != null) {
            user.getUserInfo().setRegistrationDate(userDto.getRegistrationDate());
        }
        if (userDto.getIsPremium() != null) {
            user.getUserInfo().setPremium(userDto.getIsPremium());
        }
        if (userDto.getIsCoach() != null) {
            user.getUserInfo().setCoach(userDto.getIsCoach());
        }
        if (StringUtils.isEmpty(userDto.getAvatarUrl())) {
            user.getUserInfo().setAvatarUrl(userDto.getAvatarUrl());
        }
        if (userDto.getWeight() != null) {
            user.getUserCharacteristics().setWeight(userDto.getWeight());
        }
        if (userDto.getPulse() != null) {
            user.getUserCharacteristics().setPulse(userDto.getPulse());
        }
        if (userDto.getHeight() != null) {
            user.getUserCharacteristics().setHeight(userDto.getHeight());
        }
        if (userDto.getSysPressure() != null) {
            user.getUserCharacteristics().setSysPressure(userDto.getSysPressure());
        }
        if (userDto.getDiasPressure() != null) {
            user.getUserCharacteristics().setDiasPressure(userDto.getDiasPressure());
        }
        if (userDto.getSlept() != null) {
            user.getUserCharacteristics().setSlept(userDto.getSlept());
        }
        if (!userDto.getWebinars().isEmpty()) {
            List<Webinar> webinars = userDto.getWebinars().stream()
                    .map(webinarName -> webinarRepository.findByName(webinarName).orElseThrow(WebinarNotFoundException::new))
                    .collect(Collectors.toList());
            user.getWebinars().addAll(webinars);
        }
        userRepository.save(user);
    }

    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return UserMapper.convert(user);
    }
}
