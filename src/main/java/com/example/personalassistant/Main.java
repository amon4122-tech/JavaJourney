package com.example.personalassistant;

// Author: synthyentzer //

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        StringMethods.printStartBanner();
        Scanner sc = new Scanner(System.in);
        Archive archive = new Archive();
        TaskList list = new TaskList(archive);
        NoteList notes = new NoteList(archive);
        StringMethods.greetUser(sc);
        mainMenu(sc, list, notes, archive);
        StringMethods.printEndBanner();
    }


    static void mainMenu(Scanner sc, TaskList list, NoteList notes, Archive archive) {

        int choice;
        do {
            MenuMethods.MainMenuStr();
            choice = MenuMethods.readInt(sc, "Выбор: ");
            sc.nextLine();
            MenuMethods.dispatchMenuChoice(choice, sc, list, notes, archive);
            System.out.println();
        } while (choice != 0);
    }



}

