package ru.kpfu.itis.group907.fayzullin.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.group907.fayzullin.model.User;
import ru.kpfu.itis.group907.fayzullin.repository.UserRepository;
import ru.kpfu.itis.group907.fayzullin.service.UserService;

import javax.servlet.http.HttpServletRequest;

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
    @ResponseBody
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/user")
    @ResponseBody
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    //    @PostMapping("/register")
    //    @ResponseBody
    //    public User createUser(@RequestParam String params) throws IOException {
    //        User user = objectMapper.readValue(params, User.class);
    //        return userRepository.save(user);
    //    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public String signUp(@RequestBody @ModelAttribute User user, HttpServletRequest request) {
        userService.signUp(user, request.getRequestURL().toString().replace(request.getServletPath(), ""));
        return "sign_up_success";
    }

    // - Registration -

    @GetMapping("/sign_in")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    // - Login -

}


//    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
//    public String signUp(@RequestBody @ModelAttribute User user, HttpServletRequest request) {
//        userService.signUp(user, request.getRequestURL().toString().replace(request.getServletPath(), ""));
//        return "sign_up_success";
//    }
//
//    @GetMapping("/verify")
//    public String verify(@Param("code") String code) {
//        if (true /*userService.verify(code)*/) {
//            return "verification_success";
//        } else {
//            return "verification_failed";
//        }
//    }