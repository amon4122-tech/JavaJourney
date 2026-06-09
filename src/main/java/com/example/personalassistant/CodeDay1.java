package com.example.personalassistant;

import java.util.Scanner;

public class CodeDay1 {
    public static void main (String[] args){
        //День 1
        StringMethods.printBanner_Start();
        Scanner sc = new Scanner(System.in);

        int day = 1, week = 1;


        int a = 7, b = 3;

        System.out.println("Я задал 2 числа: " + a + " и " + b + ".");
        System.out.println("Базовые арифметические операции на примере этих чисел:");
        System.out.println("Сумма чисел: " + a + " + " + b + " = " + (a+b));
        System.out.println("Разность чисел: " + a + " - " + b + " = " + (a-b));
        System.out.println("Произведение чисел: " + a + " * " + b + " = " + (a*b));
        System.out.println("Остаток от деления чисел " + a + " и " + b + " = " + (a%b));

        System.out.println();

        System.out.println("Также я написал простенький метод SQUARE, который возвращает квадрат числа.");
        System.out.println("В качестве примера ее работы, вернем квадрат числа 5: " + Calculate.square(5));
        System.out.println("Мне кажется, получилось здорово! :з");

        int start = 1, end = 10;
        System.out.println("Ну и напоследок напишем числа от " + start + " до " + end + ".");
        System.out.println();
        StringMethods.printTable(start,end);
        System.out.println();

        StringMethods.printEndBanner();
    }
}
