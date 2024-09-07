package com.example.estore.EstoreApp.controller;

import com.example.estore.EstoreApp.entities.User;
import com.example.estore.EstoreApp.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;


    @GetMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public List<User> getUsers() {
        return userServiceImpl.getUsers();
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userServiceImpl.addUser(user)) ;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userServiceImpl.deleteUser(userId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        return ResponseEntity.ok(userServiceImpl.updateUser(userId, user)) ;
    }
}
