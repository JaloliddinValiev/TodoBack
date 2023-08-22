package com.example.TodoBack.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();

    }



    @PostMapping
    public void registerNewPerson(@RequestBody Todo todo) {
        todoService.addNewPerson(todo);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody Map<String,String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        if (todoService.authenticate(username,password)) {
            return ResponseEntity.ok("Login successful");
        }else {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

}
