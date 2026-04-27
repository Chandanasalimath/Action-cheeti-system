package com.actioncheeti.actioncheeti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository repo;

    // ✅ Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }

    // ✅ Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = repo.findByUsername(user.getUsername());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return "✅ Login Success | Role: " + dbUser.getRole();
        }

        return "❌ Invalid Credentials";
    }
}