package com.example.personalassistant;

// Author: synthyentzer //

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Note {


    private final String title;
    private final String body;
    private final LocalDateTime createdAt;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String noteName = MenuMethods.readStr(sc, "Введите имя заметки: ");
        String bodyName = MenuMethods.readStr(sc, "Введите содержание заметки: ");
        Note note = new Note(noteName, bodyName);

        System.out.println("Заметка создана: ");
        System.out.println(note);

    }

    public Note(String title, String body) {
        if (!title.isBlank()) {
            this.title = title;
        } else {
            this.title = "Без названия";
        }
        if (!body.isBlank()) {
            this.body = body;
        }else {
            this.body = "Пустая заметка.";
        }
        this.createdAt = LocalDateTime.now();
    }

    /*public String getTitle(){
        return title;
    }

    public String getBody(){
        return body;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    */

    @Override
    public String toString() {
        return "Имя заметки: " + title + System.lineSeparator() + "Содержание заметки: " + body + "." + System.lineSeparator()
                + "Дата создания: " + createdAt.format(FORMATTER) + ".";
    }
}
