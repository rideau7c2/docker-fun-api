package com.gitlab.rideau7c2.dockerfunapi.rest;

import com.gitlab.rideau7c2.dockerfunapi.mongo.ConfirmToken;
import com.gitlab.rideau7c2.dockerfunapi.mongo.ConfirmTokenRepository;
import com.gitlab.rideau7c2.dockerfunapi.mongo.User;
import com.gitlab.rideau7c2.dockerfunapi.mongo.UserRepository;
import com.gitlab.rideau7c2.dockerfunapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;


@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ConfirmTokenRepository confirmTokenRepository;
    @Value("${spring.hostname}")
    String HOST_NAME;
    @Value("${server.servlet.context-path}")
    String PATH;

    @PostMapping("/registration")
    public void registerUserAccount(@RequestBody @Valid User user) {
        user.setMatchingPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        userRepository.save(user);
        String token = UUID.randomUUID().toString();
        ConfirmToken confirmToken = new ConfirmToken();
        confirmToken.setToken(token);
        confirmToken.setUser(user);
        confirmTokenRepository.save(confirmToken);
        String message = String.format("confirm: %s%s/user/confirm?token=%s", HOST_NAME, PATH, token);
        emailService.send(user.getEmail(), "Utworzono konto", message);
    }

    @GetMapping("/confirm")
    public void confirmUserAccount(@RequestParam String token) {
        ConfirmToken confirmToken = confirmTokenRepository.findByToken(token);
        confirmToken.getUser().setEnabled(true);
        userRepository.save(confirmToken.getUser());
        confirmTokenRepository.delete(confirmToken);
    }
}