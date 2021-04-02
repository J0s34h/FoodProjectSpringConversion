package ru.kpfu.itis.group907.fayzullin.service;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group907.fayzullin.model.User;
import ru.kpfu.itis.group907.fayzullin.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JavaMailSender javaMailSender;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.javaMailSender = javaMailSender;
    }

    public void signUp(User user, String url) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        String code = RandomString.make(64);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}
