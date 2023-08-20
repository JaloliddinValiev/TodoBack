package com.example.TodoBack.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;


    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
       return todoRepository.findAll();
    }

    public void addNewPerson(Todo todo) {
        System.out.println("Oyy my ");
    }
}
