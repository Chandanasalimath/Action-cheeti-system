package com.actioncheeti.actioncheeti;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String home() {
        return "Action Cheeti Running Successfully 🚀";
    }
}