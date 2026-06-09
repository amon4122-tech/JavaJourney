package com.example.personalassistant;

import java.util.Scanner;

public class Warmup {
    public static void main (String[] args){
        //День 1
        System.out.println("---Разминка. День 1.---");

        int x = 5;
        x /= 2;
        double y = 5;
        y /= 2;

        System.out.println(x);
        System.out.println(y);

        int n = 4;
        int m = 7;
        boolean result;

        result = Calculate.isEven(n);
        System.out.println("Число " + n + " четное? Ответ: " + result);
        result = Calculate.isEven(m);
        System.out.println("Число " + m + " четное? Ответ: " + result);

        System.out.println("---Разминка закончена.---");

        //День 2
        System.out.println("---Разминка. День 2.---");

        String a = "hello";
        String b = "hello";
        System.out.println(a == b);
        System.out.println(a.equals(b));

        double avg_result = average(4,7,9);
        System.out.printf("%.2f%n", avg_result);

        System.out.println("---Разминка закончена.---");

        System.out.println("---Разминка. День 3.---");

        Scanner in = new Scanner(System.in);

        System.out.println("Привет! Укажи количество набранных очков:");
        int score = in.nextInt();
        if (score < 50){
            System.out.println("Плохо");
        } else if (score < 80){
            System.out.println("Норм");
        } else {
            System.out.println("Отлично!");
        }

        System.out.println("---Разминка закончена.---");

        System.out.println("---Разминка. День 4.---");
        System.out.println();
        System.out.println("Посчитаем сумму чисел от 1 до...");
        System.out.println("Введите конечно число: ");
        int endNumber = in.nextInt();
        int sum = 0;
        for (int i = 1; i <= endNumber; i++) {
            System.out.println("Итерация номер " + i + ".");
            System.out.println(sum + " + " + i);
            sum += i;
            System.out.println("Промежуточная сумма чисел равна " + sum + "!");
        }
        System.out.println("Сумма чисел от 1 до " + endNumber+ " равна " + sum + "!");

        System.out.println("---Разминка закончена.---");

    }


    static double average(int x, int y, int z){
        return (x+y+z)/3.0;
    }
}
