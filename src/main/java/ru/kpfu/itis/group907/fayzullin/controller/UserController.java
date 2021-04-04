package ru.kpfu.itis.group907.fayzullin.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.group907.fayzullin.model.User;
import ru.kpfu.itis.group907.fayzullin.repository.UserRepository;
import ru.kpfu.itis.group907.fayzullin.service.UserService;

import java.io.IOException;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    private final ObjectMapper objectMapper;


    @Autowired
    public UserController(UserRepository userRepository, UserService userService, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.encoder = encoder;

        this.objectMapper = new ObjectMapper();
    }

    // - Profiles -

    @GetMapping("/user/{id}")
    public String getUser(Model model, @PathVariable int id) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);

        return "profile";
    }

    @GetMapping("/user")
    @ResponseBody
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    // - Registration -

    @PostMapping("/register")
    @ResponseBody
    public String createUser(@RequestBody @ModelAttribute User user) throws IOException {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "TRUE";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    // - Login -

    @GetMapping("/sign_in")
    public String login() {
        return "loginPage";
    }
}