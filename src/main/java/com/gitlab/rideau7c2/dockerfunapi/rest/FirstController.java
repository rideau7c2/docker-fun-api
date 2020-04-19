package com.gitlab.rideau7c2.dockerfunapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    public FirstController() {
    }

    @GetMapping({"/test"})
    String test() {
        return "Zgłasza się docker-fun-api \uD83D\uDC33 \uD83C\uDF0A \uD83C\uDFC4";
    }
}