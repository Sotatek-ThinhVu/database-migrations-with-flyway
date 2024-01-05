package com.example.DatabaseMigrations.service;

import com.example.DatabaseMigrations.model.Person;
import com.example.DatabaseMigrations.repository.mysql.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAll(){
        return personRepository.findAll();
    }
}
