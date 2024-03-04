package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entities.Todo;
import com.todo.service.ITodoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api")
public class TodoController {
	
	@Autowired
	private ITodoService service;
	
	@PostMapping(value="/save")
	public Todo save(@RequestBody Todo request){
		return service.save(request);
		
	}
	
	@PutMapping("update/{id}")
	public Todo update(@PathVariable("id") int id,@RequestBody Todo request) throws Exception{
		return service.update(id,request);
		
	}
	
	@DeleteMapping("delete/{id}")
	public boolean delete(@PathVariable("id") int id) throws Exception{
		return service.delete(id);
		
	}
	
	@GetMapping("tasks")
	public List<Todo> retrieveAll(){
		return service.retrieveAll();
		
	}
	
	@PutMapping("task/{id}")
	public Todo retriveById(@PathVariable("id") int id) throws Exception{
		return service.retrieveById(id);
		
	}

}
