package com.example.firstspring.app.controller;

import com.example.firstspring.app.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class userController {
    private final Map<Integer, User> userDb = new HashMap<>();

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println(user.getEmail());
        userDb.putIfAbsent(user.getId(), user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//        Object ResponseEntity;
//        HttpStatus created = HttpStatus.CREATED;
//        return ResponseEntity<>(user,HttpStatus.CREATED);
    }
    

    @PutMapping
    public String updateUser(@RequestBody User user) {
        if(userDb.containsKey(user.getId()))  userDb.put(user.getId(), user);
        return "update successful";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        userDb.remove(id);
        return "User deleted successful";
    }

    @GetMapping
    public List<User> getUsers(){
        return new ArrayList<>(userDb.values());
    }
}