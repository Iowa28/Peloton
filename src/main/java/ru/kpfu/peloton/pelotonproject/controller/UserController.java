package ru.kpfu.peloton.pelotonproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.peloton.pelotonproject.dto.UserDto;
import ru.kpfu.peloton.pelotonproject.service.SignUpService;
import ru.kpfu.peloton.pelotonproject.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final SignUpService signUpService;
    private final UserService userService;

    @GetMapping("/sign_in")
    public String getSignInPage() {
        return "sign_in";
    }

    @PostMapping("/sign_in")
    public String signIn(String email, String password) {
        if (signUpService.signIn(email, password)) {
            return "main";
        }
        return "redirect:/sign_in";
    }

    @GetMapping("/main")
    public String getMainPage(ModelMap map) {
        map.addAttribute("test", "Привет");
        return "main";
    }

    @GetMapping("/health/{user-id}")
    public String getHealthPage(ModelMap map, @PathVariable("user-id") String userId) {
        map.addAttribute("user", userService.getUser(Long.parseLong(userId)));
        return "health";
    }

    @PostMapping("/health/{user-id}")
    public String updateUser(@PathVariable("user-id") String userId, UserDto userDto) {
        userService.updateUser(Long.parseLong(userId), userDto);
        return "redirect:/health/" + userId;
    }
}
