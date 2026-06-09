package com.example.personalassistant;

// Author: synthyentzer //

import java.util.ArrayList;
import java.util.Scanner;

public class NoteList {

    private final ArrayList<Note> notes = new ArrayList<>();


    public void menuNotes(Scanner sc){

        int choice;
        do {
            openMenuNotes();
            choice = MenuMethods.readInt(sc, "Выберите пункт меню: ");
            sc.nextLine();
            notesMenu(choice, sc);
            System.out.println();
        } while (choice!=0);

    }

    public void openMenuNotes(){
        System.out.println("1 — добавить заметку");
        System.out.println("2 — показать все заметки");
        System.out.println("0 — выход");
    }

    public void notesMenu(int n, Scanner sc){
        switch (n){
            case 1 -> addNote(sc);
            case 2 -> printAllNotes();
            case 0 -> System.out.println("Хорошего дня!");
            default -> System.out.println("Некорректный ввод. Попробуйте еще раз.");
        }

    }

    public void addNote(Scanner sc){

        String noteName = MenuMethods.readStr(sc, "Введите имя заметки: ");
        String noteBody = MenuMethods.readStr(sc, "Введите содержание заметки: ");
        notes.add(new Note(noteName, noteBody));
        System.out.println("Заметка добавлена!");
    }

    public void printAllNotes(){
        if (notes.isEmpty()){
            System.out.println("Список пуст!");
        } else {
            for (Note n : notes){
                System.out.println(n);
                System.out.println("-----------------------");
            }
        }
    }
}
