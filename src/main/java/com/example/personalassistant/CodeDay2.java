package com.example.personalassistant;

import java.util.Scanner;

public class CodeDay2 {
    public static void main(String[] args){
        //День 2
        Scanner sc = new Scanner(System.in);
        StringMethods.printStartBanner();
        StringMethods.greetUser(sc);
        int day = 2; int week = 1;

        System.out.println("Всем привет, если кто-то это читает!");
        System.out.println("Наступил день " + day + ", недели " + week + " моего обучения.");
        System.out.println("Сегодня тренируемся с методом вводом/выводом.");
        System.out.println();

        Calculate.calc(sc);
        StringMethods.printEndBanner();
    }
}
