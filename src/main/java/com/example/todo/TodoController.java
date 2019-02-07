package com.example.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("work", "stand up at 10:00 am"));
        todos.add(new Todo("personal", "sleep at 11:30 pm"));
        todos.add(new Todo("family", "outside lunch on every sunday"));
        return todos;
    }

}
