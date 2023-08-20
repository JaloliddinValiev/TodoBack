package com.example.TodoBack.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TodoConfig {
    @Bean
    CommandLineRunner commandLineRunner(TodoRepository repository) {
        return args -> {
            Todo adam = new Todo(
              "Adam",
              "kabob",
                    "qwerty"

            );

            Todo bakzod = new Todo(
                    "Bekzod",
                    "Beccoder",
                    "ytrewq"

            );
            repository.saveAll(List.of(adam,bakzod));

        };
    }

}
