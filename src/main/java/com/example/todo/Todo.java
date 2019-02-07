package com.example.todo;

public class Todo {
    private String title;
    private String desc;

    Todo(String title, String desc){
        this.title = title;
        this.desc = desc;
    }

    public String getTitle(){
        return title;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
