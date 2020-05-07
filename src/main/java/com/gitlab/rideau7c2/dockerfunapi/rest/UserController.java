package com.gitlab.rideau7c2.dockerfunapi.rest;

import com.gitlab.rideau7c2.dockerfunapi.mongo.User;
import com.gitlab.rideau7c2.dockerfunapi.mongo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registration")
    public void registerUserAccount
            (@RequestBody @Valid User user) {
        user.setMatchingPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}