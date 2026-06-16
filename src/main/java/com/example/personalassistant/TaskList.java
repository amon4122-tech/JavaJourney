package com.example.personalassistant;

// Author: synthyentzer //

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class TaskList {

    private final ArrayList<Task> tasks = new ArrayList<>();
    public final Archive archive;

    public TaskList(Archive archive) {
        this.archive = archive;
    }

    public void menuTasks(Scanner sc){

        int choice;

        do {
            openTaskMenu();
            choice = MenuMethods.readInt(sc, "Выберите пункт меню: ");
            sc.nextLine();
            taskMenu(choice, sc);
            System.out.println();
        } while (choice != 0);
    }

    public void openTaskMenu(){
        System.out.println("1 — добавить задачу");
        System.out.println("2 — показать все задачи");
        System.out.println("3 — изменить статус задачи");
        System.out.println("4 — сколько выполнено");
        System.out.println("5 — невыполненные задачи");
        System.out.println("6 — удаление задач");
        System.out.println("7 — поиск по задачам");
        System.out.println("8 — статистика по категориям");
        System.out.println("9 — отсортировать список задач");
        System.out.println("0 — выход");
    }

    public void taskMenu(int n, Scanner sc){
            switch (n) {
                case 1 -> addTask(sc);
                case 2 -> printAll();
                case 3 -> switchStatus(sc);
                case 4 -> System.out.println("Выполнено: " + countDone());
                case 5 -> printPending();
                case 6 -> deleteTask(sc);
                case 7 -> {
                    String search = MenuMethods.readStr(sc, "Введите имя задачи: ");
                    if(search.isBlank()){
                        System.out.println("Поиск по пустой строке невозможен.");
                    } else {
                        findByTitlePart(search);
                    }
                }
                case 8 -> countByCategory();
                case 9 -> sortByTitle();
                case 0 -> System.out.println("Хорошего дня!");
                default -> System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
    }

    public void printPending(){
        int totalTasks = tasks.size();
        if (tasks.isEmpty()){
            System.out.println("Список задач пуст!");
            return;
        }
        for(Task t : tasks){
            if (t.getStatus() == Status.IN_PROGRESS || t.getStatus() == Status.NEW){
                System.out.println(t);
            }

        }
        if (countDone() == totalTasks){
            System.out.println("Все задачи выполнены! Так держать!");
        }
    }

    public void addTask(Scanner sc){
        String title = MenuMethods.readStr(sc, "Укажите имя задачи: ");
        String category = MenuMethods.readStr(sc, "Укажите категорию задачи:");
        tasks.add(new Task(title, category));
        archive.addRecord(new Task(title, category));
        System.out.println("Задача добавлена!");
    }

    public void printAll() {
        if (tasks.isEmpty()) {
            System.out.println("Список пуст!");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("Задача №" + (i+1) + ": " + System.lineSeparator() + tasks.get(i));
            }
        }
    }

    public int countDone(){
        int count = 0;
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getStatus() == Status.DONE){
                count++;
            }
        }
        return count;
    }

    public void deleteTask (Scanner sc) {
        int choice;
        do{
            deleteTaskMenu();
            choice = MenuMethods.readInt(sc, "Выберите вариант удаления:");
            sc.nextLine();
            deleteTaskMeth(choice, sc);
        } while (choice != 0);

    }

    public void switchStatus(Scanner sc){

        if (tasks.isEmpty()){
            System.out.println("Список задач пуст!");
            return;
        }

        int nTask = MenuMethods.readInt(sc, "Введите номер задачи: ");
        nTask-=1;
        System.out.println();

        if (nTask < 0 || nTask >= tasks.size()) {
            System.out.println("Задача с таким номером в списке отсутствует. Повторите ввод.");
            return;
        }

        if (tasks.get(nTask).getStatus() == Status.NEW){
            tasks.get(nTask).setStatus(Status.IN_PROGRESS);
            System.out.println("Статус задачи изменен! Текущий статус: [В процессе]" );
        } else {
            tasks.get(nTask).setStatus(Status.DONE);
            System.out.println("Статус задачи изменен! Текущий статус: [Завершено]" );
        }
    }

    public void deleteTaskMenu() {
        System.out.println("======= УДАЛЕНИЕ ЗАДАЧ =======");
        System.out.println("1. Убрать задание ============");
        System.out.println("2. Очистить список полностью =");
        System.out.println("0. Выход =====================");
    }

    public void deleteTaskMeth(int n, Scanner sc){
        switch (n){
            case 1 -> deleteTaskSingle(sc);
            case 2 -> deleteTasksAll();
            case 0 -> System.out.println("Выход в меню...");
            default -> System.out.println("Некорректный ввод. Попробуйте еще раз.");
        }
    }

    public void deleteTaskSingle (Scanner sc){
        int index = MenuMethods.readInt(sc, "Введите номер задачи: ");
        sc.nextLine();
        if (index < 0 || index >= tasks.size()){
            System.out.println("Задача с таким номером в списке отсутствует. Повторите ввод.");
        } else {
            tasks.remove(index);
            System.out.println("Задача № " + index + " убрана!");
        }
    }

    public void deleteTasksAll(){
        tasks.clear();
        System.out.println("Список очищен!");
    }

    public void countByCategory(){

        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст!");
            return;
        }

        HashMap<String, Integer> categoryStats = new HashMap<>();

        for (Task t : tasks){
            String cat = t.getCategory();

            if (!categoryStats.containsKey(cat)){
                categoryStats.put(cat, 1);
            } else {
                categoryStats.put(cat, categoryStats.get(cat)+1);
            }
        }

        System.out.println("=== СТАТИСТИКА ПО КАТЕГОРИЯМ ===");
        for (var entry : categoryStats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " шт.");
        }
        System.out.println("================================");
    }

    public void findByTitlePart(String part){

        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст!");
            return;
        }
        boolean found = false;
        for (Task t : tasks){
            if (t.getTitle().toLowerCase().contains(part.toLowerCase())){
                found = true;
                System.out.println("Задача обнаружена!");
                System.out.println(t);
            }
        }

        if (!found){
            System.out.println("Совпадений не обнаружено.");
        }
    }

    public void sortByTitle(){

        if (tasks.isEmpty()){
            System.out.println("Список задач пуст, сортировать нечего!");
            return;
        }

        tasks.sort(Comparator.comparing(Task::getTitle));
        System.out.println("Задачи успешно отсортированы по алфавиту");
        printAll();
    }
}


