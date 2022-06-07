package dev.example.demo.controller;

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

import dev.example.demo.model.Todo;
import dev.example.demo.service.TodoService;

@RestController //@Controller(==@Component) + @ResponseBody
@RequestMapping("api/v1/todos")
@CrossOrigin("*")
public class TodoController {
	
	@Autowired // 필드를 통한 인젝션(주입, DI)
	private TodoService todoservice;
	
	@GetMapping 
	public List<Todo> findAll() {
		System.out.println("findAll() called");
		return todoservice.findAll();
	}
	
	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		System.out.println(todo);
		return todoservice.save(todo);
	}
	
	@PutMapping
	public List<Todo> update(@RequestBody Todo todo){
		return todoservice.update(todo);
	}
	
	@DeleteMapping("/{id}")
	public List<Todo> delete(@PathVariable("id") Long id){
		return todoservice.delete(id);	}
	
	
}
