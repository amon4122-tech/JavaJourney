package com.example.personalassistant;

// Author: synthyentzer

import java.util.Scanner;

public class MenuMethods {

    public static int readIntLn(Scanner sc, String str) {
        System.out.println(str);
        while (!sc.hasNextInt()) {
            System.out.println("Ошибка ввода! Введите целое число!");
            sc.next();
        }
        return sc.nextInt();
    }

    public static int readInt(Scanner sc, String str) {
        System.out.print(str);
        while (!sc.hasNextInt()) {
            System.out.println("Ошибка ввода! Введите целое число!");
            sc.next();
        }
        return sc.nextInt();
    }

    public static String readStr(Scanner sc, String str) {
        System.out.println(str);
        return sc.nextLine();
    }

    public static void MainMenuStr() {
        System.out.println("Выберете нужный пункт в меню системы:");
        System.out.println("========== Меню ===========");
        System.out.println("1 - калькулятор ===========");
        System.out.println("2 - таблица умножения =====");
        System.out.println("3 - четное / нечетное =====");
        System.out.println("4 - простое ли число? =====");
        System.out.println("5 - о создателе ===========");
        System.out.println("6 - массив чисел ==========");
        System.out.println("7 - работа со строкой =====");
        System.out.println("8 - создание задачи =======");
        System.out.println("9 - задачи ================");
        System.out.println("10 - заметки ==============");
        System.out.println("0 - выход =================");
    }

    public static void dispatchMenuChoice(int n, Scanner sc, TaskList list, NoteList notes) {
        switch (n) {
            case 1 -> Calculate.calc(sc);
            case 2 -> Calculate.multipleTable(sc);
            case 3 -> Calculate.checkEven(sc);
            case 4 -> Calculate.checkPrime(sc);
            case 5 -> StringMethods.creatorInfo();
            case 6 -> Calculate.arrayNumbers(sc);
            case 7 -> StringMethods.analyzeString(sc);
            case 8 -> StringMethods.createTask(sc);
            case 9 -> list.menuTasks(sc);
            case 10 -> notes.menuNotes(sc);
            case 0 -> System.out.println("Хорошего дня!");
            default -> System.out.println("Нет такого пункта.");
        }
    }

    public static void CalcMenu() {
        System.out.println("=======Калькулятор=======");
        System.out.println(" 1. Сложение  2. Вычитание");
        System.out.println(" 3. Умножение  4. Деление");
        System.out.println(" 5. Остаток деления  0. Выход");
    }
}
