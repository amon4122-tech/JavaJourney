package com.example.personalassistant;

// Author: synthyentzer //

public class Task extends Record {

    private Status done;
    private final String category;

    public Task (String title, String category){

        super(title);
        this.done = Status.NEW;

        if (category.isBlank()){
            this.category = "Без категории";
        } else {
            this.category = category;
        }

    }

    public void markDone(){
        this.done = Status.DONE;
    }

    public Status getStatus() {
        return this.done;
    }

    public String getCategory() {
        return category;
    }

    public void setStatus(Status status){
        this.done = status;
    }
    @Override
    public String toString() {
        String statusStr = "";
        switch (getStatus()){
            case NEW -> statusStr = "[Новая]";
            case DONE -> statusStr = "[Завершено]";
            case IN_PROGRESS -> statusStr = "[В процессе]";
        }

        return statusStr + " " +
                "Имя: " + super.getTitle() + System.lineSeparator()
                + "Категория: " + category + System.lineSeparator()
                + "Дата создания: " + super.getFormattedCreatedAt();
    }
}
