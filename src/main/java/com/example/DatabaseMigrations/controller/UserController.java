package com.example.DatabaseMigrations.controller;


import com.example.DatabaseMigrations.model.Message;
import com.example.DatabaseMigrations.model.Person;
import com.example.DatabaseMigrations.model.User;
import com.example.DatabaseMigrations.service.PersonService;
import com.example.DatabaseMigrations.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;
    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok(new Message("Oce"));
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> list = userService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/person/all")
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> list = personService.getAll();
        return ResponseEntity.ok(list);
    }
}
