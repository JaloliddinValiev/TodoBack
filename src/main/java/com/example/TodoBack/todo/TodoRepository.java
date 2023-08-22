package com.example.TodoBack.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {


    @Query("SELECT s FROM Todo s WHERE s.nickname = ?1")
    Optional<Todo> findTodoByNickname(String nickname);

    Todo findByNickname(String  nickname);
}
