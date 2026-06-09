package com.example.personalassistant;

// Author: synthyentzer //

public class Task {
    private final String title;
    private boolean done;
    private final String category;

    public Task (String title, String category){
        if (title.isBlank()){
            this.title = "Нет названия";
        } else {
            this.title = title;
        }
        this.done = false;
        if (category.isBlank()){
            this.category = "Без категории";
        } else {
            this.category = category;
        }
    }

    public void markDone(){
        this.done = true;
    }

    public boolean isDone() {
        return this.done;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        String status = done ? "[Выполнено]" : "[ ]";
        return status + " " + title + " (Категория: " + category + ")";
    }
}
