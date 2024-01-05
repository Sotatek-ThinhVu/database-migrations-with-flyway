package com.example.DatabaseMigrations.service;

import com.example.DatabaseMigrations.model.User;
import com.example.DatabaseMigrations.repository.postgresql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
