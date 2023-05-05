package com.example.jjdind49_katibar_zad27_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new UserDto());

        return "home";
    }

    @PostMapping("/")
    public String homeForm(@RequestBody UserDto userDto) {
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        LocalDate birthday = userDto.getBirthday();
        userRepository.save(new User(firstName, lastName, birthday));

        return "redirect:/home";
    }
}
