package com.example.firstspring.app;

import com.example.firstspring.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class userController {
    private final Map<Integer, User> userDb = new HashMap<>();

    @PostMapping
    public String createUser(@RequestBody User user) {
        userDb.put(user.getId(), user);
        return "success";
    }
}