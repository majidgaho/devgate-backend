package com.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entities.Todo;
import com.todo.repos.TodoRepo;

@Service
public class TodoServiceImpl implements ITodoService {

	@Autowired
	private TodoRepo repo;

	@Override
	public Todo save(Todo todo) {

		return repo.save(todo);

	}

	@Override
	public Todo update(int id, Todo request) throws Exception {
		Optional<Todo> existing = repo.findById(id);
		Todo updatedTask;
		if (existing.isPresent()) {
			Todo todo = existing.get();
			todo.setStatus(request.getStatus());
			updatedTask = repo.save(todo);
		} else {
			throw new Exception("Task Not Found");
		}

		return updatedTask;
	}

	@Override
	public boolean delete(int id) {
		Optional<Todo> existing = repo.findById(id);
		repo.delete(existing.get());
		return true;
	}

	@Override
	public List<Todo> retrieveAll() {
		return repo.findAll();

	}

	@Override
	public Todo retrieveById(int id) throws Exception {
		Optional<Todo> task = repo.findById(id);
		if (task.isPresent()) {
			return task.get();
		} else {
			throw new Exception("Task Not Found");
		}
	}
}
