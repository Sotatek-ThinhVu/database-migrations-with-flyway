package com.example.DatabaseMigrations.controller;


import com.example.DatabaseMigrations.model.Message;
import com.example.DatabaseMigrations.model.User;
import com.example.DatabaseMigrations.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok(new Message("Oce"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> list = userService.getAll();
        return ResponseEntity.ok(list);
    }
}
