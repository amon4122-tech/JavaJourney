package com.example.personalassistant;

// Author: synthyentzer //

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StringMethods {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    static void printTable(int from, int to){
        for (int i = from; i <= to; i++){
            System.out.println(i);
        }
    }

    static void printBanner_Start(){
        System.out.println("=====Начало=====");
        System.out.println("======Пути======");
        System.out.println("==Программиста==");
        System.out.println();
    }

    static void printStartBanner(){
        System.out.println("======Запуск======");
        System.out.println("====Системного====");
        System.out.println("====Окружения=====");
        System.out.println();
    }

    static void printEndBanner(){
        System.out.println("=====Выход=====");
        System.out.println("=======Из======");
        System.out.println("====Системы====");
        System.out.println();
    }

    static void creatorInfo() {
        int age = 31;
        String greeting = "Меня зовут Александр.";
        boolean wish = true;
        System.out.println("Приветствую, друг! " + greeting);
        System.out.println("Мне " + age + ".");
        System.out.println("Правда ли я хочу стать программистом? It's " + wish + ".");
        System.out.println("Эта программа - мой скромный старт в карьере Java-разработчика.");
        System.out.println();
    }

    static void analyzeString(Scanner sc){
        String nString = MenuMethods.readStr(sc, "Введите строку: ");
        int nStrLength = nString.length();
        if (nString.isEmpty()) {
            System.out.println("Пустая строка!");
            return;
        }
        System.out.println("Длина введенной строки: " + nStrLength);
        System.out.println("Первый символ строки: " + nString.charAt(0));
        System.out.println("Последний символ строки: " + nString.charAt(nStrLength - 1));
        StringBuilder nStrBuild = new StringBuilder(nString);
        System.out.println("Развернутая строка: " + nStrBuild.reverse());
        if (nString.contentEquals(nStrBuild)){
            System.out.println("Строка является палиндромом!");
        }else{
            System.out.println("Строка не является палиндромом!");
        }
    }

    static void createTask(Scanner sc){
        System.out.println("Создайте задачу: ");
        Task newTask = new Task(sc.nextLine(), sc.nextLine());
        System.out.println(newTask);
        newTask.markDone();
        System.out.println(newTask);
    }

    static void greetUser(Scanner sc) {
        System.out.println("======Проверка доступа...======");

        String name = MenuMethods.readStr(sc, "===Пожалуйста, представьтесь===");
        int age = MenuMethods.readIntLn(sc, "=======Сколько вам лет?=======");
        sc.nextLine();
        System.out.println("=Приветствую, " + name + ". Тебе " + age + " лет!=");

        if (age >= 18){
            System.out.println("==Проверка возраста пройдена! Доступ разрешен!==");
        } else {
            System.err.println("=Проверка возраста провалена! Доступ запрещен!=");
            System.exit(-1);
        }
        System.out.println();

        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(FORMATTER);

        System.out.println("Добро пожаловать в систему YENTZERSYSTEM (v.0.1)");
        System.out.println("Время входа: " + formattedDateTime);
        System.out.println();
    }


}
