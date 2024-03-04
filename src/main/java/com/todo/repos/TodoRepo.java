package com.todo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entities.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer> {

}
