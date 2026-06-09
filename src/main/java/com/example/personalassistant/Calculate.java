package com.example.personalassistant;

// Author: synthyentzer //

import java.util.Scanner;

public class Calculate {

    public static void main (String[] args){

    }

    static void calc(Scanner sc) {

        int n = MenuMethods.readIntLn(sc,"Укажите первый операнд:");
        sc.nextLine();
        int m = MenuMethods.readIntLn(sc,"Укажите второй операнд:");
        sc.nextLine();

        int menuChoice;

        M: do {
            MenuMethods.CalcMenu();
            menuChoice = MenuMethods.readInt(sc, "Выберете алгебраическое действие: ");
            sc.nextLine();

            switch (menuChoice) {
                case 1:
                    System.out.printf("Ответ: %d", n + m);
                    System.out.println();
                    break;
                case 2:
                    System.out.printf("Ответ: %d", n - m);
                    System.out.println();
                    break;
                case 3:
                    System.out.printf("Ответ: %d", n * m);
                    System.out.println();
                    break;
                case 4:
                    if (m == 0) {
                        System.out.println("Делить на ноль - НЕЛЬЗЯ!");
                    } else
                        System.out.printf("Ответ: %d", n / m);
                    System.out.println();
                    break;
                case 5:
                    if (m == 0) {
                        System.out.println("Делить на ноль - НЕЛЬЗЯ!");
                    } else
                        System.out.printf("Ответ: %d", n % m);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Выход из калькулятора...");
                    break;
                default:
                    System.out.println("Нет такой операции.");
                    continue M;
            }

            if (menuChoice == 0) {
                break;
            }

            System.out.println();
            System.out.print("Продолжим работу с этими же числами? (y/n): ");
            String answer_1 = sc.nextLine();

            if (answer_1.equals("y")){
                continue M;
            } else {
                System.out.println("Дальнейшие действия:");
                System.out.println("1. Ввод новых чисел");
                System.out.println("0. Выход");
                int answer_2 = sc.nextInt();
                switch (answer_2){
                    case 1:
                        System.out.println("Введите новую пару чисел:");
                        n = sc.nextInt();
                        sc.nextLine();
                        m = sc.nextInt();
                        sc.nextLine();
                        continue M;
                    case 0 :
                        menuChoice = 0;
                }
            }
        } while (menuChoice != 0);
    }

    static void multipleTable(Scanner sc){
        String answerTable;
        System.out.println("Добро пожаловать в Таблицу умножения!");

        U:  do {
            System.out.println("Введите число, для которого вы хотите" + "\n" +
                    "вывести таблицу умножения: ");
            int num = sc.nextInt();
            sc.nextLine();
            Calculate.printMultiplicationTable(num);
            System.out.println();

            System.out.print("Продолжим работу с таблицей умножения? (y/n)");
            answerTable = sc.nextLine();

        } while (answerTable.equals("y"));


    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static int square(int x){
        return x * x;
    }

    static void printMultiplicationTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    static void checkEven(Scanner sc) {

        int n = MenuMethods.readIntLn(sc, "Введите целое число:");
        sc.nextLine();

        if (Calculate.isEven(n)) {
            System.out.println(n + " — чётное.");
        } else {
            System.out.println(n + " — нечётное.");
        }
        System.out.println();
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void checkPrime(Scanner sc) {

        int n = MenuMethods.readIntLn(sc, "Введите целое число:");
        sc.nextLine();

        if (Calculate.isPrime(n)) {
            System.out.println(n + " — простое.");
        } else {
            System.out.println(n + " — не простое.");
        }
        System.out.println();
    }

    static void arrayNumbers(Scanner sc){

        int countNumber = MenuMethods.readInt(sc, "Укажите размер массива чисел: ");
        sc.nextLine();
        int[] number = new int[countNumber];
        if (countNumber<1) {
            System.out.println("Длина массива равна 0");
            return;
        }

        for (int i = 0; i < number.length; i++) {
            number[i] = MenuMethods.readInt(sc, "Введите число: ");
            sc.nextLine();
        }

        int sumNum = 0;
        for (int i = 0; i < number.length; i++) {
            sumNum += number[i];
        }
        System.out.println("Сумма числе в массиве равна: " + sumNum);
        System.out.println("Среднее арифметическое равно: " + ((double)sumNum/countNumber));

        int minNum = number[0];
        for (int i = 0; i < number.length; i++) {
            if (minNum > number[i])
                minNum = number[i];
        }
        System.out.println("Минимальное число: " + minNum);

        int maxNum = number[0];
        for (int i = 0; i < number.length; i++) {
            if (maxNum < number[i])
                maxNum = number[i];
        }
        System.out.println("Максимальное число: " + maxNum);

        int countEven = 0;
        for (int i = 0; i < number.length; i++) {
            if (Calculate.isEven(number[i])) {
                countEven++;
            }
        }
        System.out.println("Четных чисел в массиве: " + countEven);
    }
}
