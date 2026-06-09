package com.example.personalassistant;

// Author: synthyentzer //

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        StringMethods.printStartBanner();
        Scanner sc = new Scanner(System.in);
        TaskList list = new TaskList();
        NoteList notes = new NoteList();
        StringMethods.greetUser(sc);
        mainMenu(sc, list, notes);
        StringMethods.printEndBanner();
    }


    static void mainMenu(Scanner sc, TaskList list, NoteList notes) {

        int choice;
        do {
            MenuMethods.MainMenuStr();
            choice = MenuMethods.readInt(sc, "Выбор: ");
            sc.nextLine();
            MenuMethods.dispatchMenuChoice(choice, sc, list, notes);
            System.out.println();
        } while (choice != 0);
    }



}

