package com.example.DatabaseMigrations.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class Message {
    private String message;
    private LocalTime timestamp;
    public Message(String message){
        timestamp = LocalTime.now();
        this.message = message;
    }
}
