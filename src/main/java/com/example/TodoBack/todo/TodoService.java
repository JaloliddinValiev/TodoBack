package com.example.TodoBack.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Todo> todoOptional = todoRepository
                .findTodoByNickname(todo.getNickname());

        if (todoOptional.isPresent()) {
            throw new IllegalStateException("nickname taken");
        }
        todoRepository.save(todo);
    }

    public boolean authenticate(String nickname, String password) {
        Todo user = todoRepository.findByNickname(nickname);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
