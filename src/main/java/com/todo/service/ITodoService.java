package com.todo.service;

import com.todo.entities.Todo;

import java.util.List;

public interface ITodoService {

    Todo save(Todo todo);

    Todo update(int id, Todo request) throws Exception;

    boolean delete(int id) throws Exception;

    List<Todo> retrieveAll();

    Todo retrieveById(int id) throws Exception;
}
