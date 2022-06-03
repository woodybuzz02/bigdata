package dev.example.demo.service;

import java.util.List;

import dev.example.demo.model.Todo;


public interface TodoService {
	List<Todo> findAll();

	Todo save(Todo todo);

	List<Todo> update(Todo todo);

	List<Todo> delete(Long id);
}
