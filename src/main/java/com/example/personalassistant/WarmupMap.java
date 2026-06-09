package com.example.personalassistant;

import java.util.HashMap;
import java.util.Scanner;

public class WarmupMap {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap <String, String> map = new HashMap<>();

        map.put("Жена", "Настя");
        map.put("Муж", "Саша");
        map.put("Кот", "Артас");

        hashMenuMeth(sc, map);

    }

    public static void hashGet(Scanner sc, HashMap<String, String> map){

        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        String choice = MenuMethods.readStr(sc, "Введите ключ-слово для получения данных:");

        if (!map.containsKey(choice)){
            System.out.println("Нет такого ключа");
            return;
        }

        System.out.println(map.get(choice));
        System.out.println();
    }

    public static void hashAll(HashMap<String, String> map){
        for(var h : map.entrySet()){
            System.out.println("Ключ: " + h.getKey() + ", Значение: " + h.getValue() + ".");
        }
        System.out.println();
    }

    public static void hashAdd(Scanner sc, HashMap<String, String> map){

        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        String addKey = MenuMethods.readStr(sc, "Введите ключ-слово для создания ячейки:");
        String addValue = MenuMethods.readStr(sc, "Введите значение для внесения в таблицу:");
        map.put(addKey,addValue);
        System.out.println("Ключ: " + addKey + ", Значение: " + addValue + " - данные внесены в таблицу.");
        System.out.println();
    }

    public static void hashMenuString(){
        System.out.println("Проверка хэш-таблицы:");
        System.out.println("1. Получить данные");
        System.out.println("2. Вывести всю таблицу");
        System.out.println("3. Добавить данные.");
        System.out.println("4. Проверка на наличие.");
        System.out.println("0. Выход.");
    }

    public static void hashMenuMeth(Scanner sc, HashMap<String, String> map){
        int choiceMenu;
        do {
            hashMenuString();
            choiceMenu = MenuMethods.readIntLn(sc, "Выберете пункт меню: ");
            sc.nextLine();
            switch (choiceMenu) {
                case 1 -> hashGet(sc, map);
                case 2 -> hashAll(map);
                case 3 -> hashAdd(sc, map);
                case 4 -> hashCheck(sc, map);
                case 0 -> System.out.println("Выход из программы...");
                default -> System.out.println("Такого пункта нет.");
            }
        } while(choiceMenu!= 0);
    }

    public static void hashCheck(Scanner sc, HashMap<String, String> map){

        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        String check = MenuMethods.readStr(sc, "Введите ключ-слово для проверки: ");

        if (!map.containsKey(check)){
            System.out.println("Нет такого ключа");
        } else {
            System.out.println("Ключ " + check + " обнаружен! Значение: " + map.get(check));
        }
        System.out.println();
    }
}
