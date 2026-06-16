package com.example.personalassistant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Record {

    private final String title;
    private final LocalDateTime createdAt;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public Record (String title) {
        if(!title.isBlank()) {
            this.title = title;
        } else {
            this.title = "Без названия";
        }
        this.createdAt = LocalDateTime.now();
    }

    public String getTitle(){
        return title;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public String getFormattedCreatedAt(){
        return createdAt.format(FORMATTER);
    }
}
