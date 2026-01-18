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
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if(!userDb.containsKey(user.getId())) {
            userDb.put(user.getId(), user);
            return ResponseEntity.notFound().build();
        } else return new ResponseEntity<>(user, HttpStatus.OK);
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

//first way
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getOrder(@PathVariable int id){
//        return ResponseEntity.ok(userDb.get(id));
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getOrder(@PathVariable("userId") int id){
        return ResponseEntity.ok(userDb.get(id));
    }

//    multiple path urls
    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<User> getOrder(
            @PathVariable("userId") int id,
            @PathVariable int orderId
    ){
        if(!userDb.containsKey(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.ok(userDb.get(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String search){

    }
}