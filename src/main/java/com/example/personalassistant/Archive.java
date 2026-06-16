package com.example.personalassistant;

import java.util.ArrayList;
import java.util.Scanner;

public class Archive {

    private final ArrayList<Record> records = new ArrayList<>();

    public void recordsMainMenu(Scanner sc){
        int choice;
        do{
            openRecordsMenu();
            choice = MenuMethods.readInt(sc, "Выберите пункт меню:");
            sc.nextLine();
            recordsMenu(choice, sc);
        }while (choice!=0);
    }

    public void openRecordsMenu(){
        System.out.println("==== Журнал событий ====");
        System.out.println("1. Посмотреть журнал ===");
        System.out.println("0. Выход ===============");
    }

    public void recordsMenu(int n, Scanner sc){
        switch (n) {
                case 1 -> printAllRecords();
                case 0 -> System.out.println("Выход в меню...");
                default -> System.out.println("Нет такого пункта");
        }
    }
    public void addRecord (Record record){
        records.add(record);
    }

    public void printAllRecords(){

        if (records.isEmpty()){
            System.out.println("Записи в журнале отсутствуют");
        }

        for (Record r : records){
            System.out.println(r);
        }
    }
}
