package com.example.personalassistant;

// Author: synthyentzer //

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Note extends Record {

    private final String body;
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

        super(title);

        if (!body.isBlank()) {
            this.body = body;
        } else {
            this.body = "Пустая заметка.";
        }
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
        return "Имя заметки: " + super.getTitle() + System.lineSeparator()
                + "Содержание заметки: " + body + "." + System.lineSeparator()
                + "Дата создания: " + super.getFormattedCreatedAt() + ".";
    }
}
