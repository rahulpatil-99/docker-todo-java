package com.example.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private void write(String file, String data){
        FileWriter writer;
        try {
            writer = new FileWriter(file, true);
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeTodoToCSV(Todo todo)  {
        write("todos.csv", "\n" + todo.toCSV());
    }

    private void createCSVFile(){
        write("todos.csv", "title,desc");
    }

    private List<Todo> readTodos() {
        List<Todo> todos = new ArrayList<>();
        Path pathToFile = Paths.get("todos.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String columns = br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Todo todo = new Todo(attributes[0],attributes[1]);
                todos.add(todo);
                line = br.readLine();
            }
        }
        catch (IOException ioe) { createCSVFile();}
        return todos;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
         return readTodos();
    }

    @PostMapping("/addTodo")
    public void addTodo(@RequestBody Todo todo) {
        writeTodoToCSV(todo);
    }
}
