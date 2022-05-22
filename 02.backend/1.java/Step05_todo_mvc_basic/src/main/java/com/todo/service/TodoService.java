package com.todo.service;

import java.nio.file.Path;
import java.util.List;
import com.todo.data.TodoTSVWriter;
import com.todo.model.Todo;

public class TodoService {
	// 비즈니스 로직(Business Logic)을 처리하는 역할
	// 비즈니스 로직 : 해당 애플리케이션에서 중요한 로직을 처리하는 부분
	
	// findById : id값에 의해서 일치하는 데이터를 찾는 로직
	
	// 2. 조회기능2, 할 일 순서 번호로 하나의 Todo 조회 메서드
	public Todo findById(List<Todo> todos, Long id) {
		for (Todo todo : todos) {
			if(todo.getId() == id) {
				return new Todo(todo.getId(), todo.getTitle(), todo.getDueDate(), todo.getDescription());
			}
		}
		return null;
	}
	
	public boolean save(String RESOURCES, Path filePath, Todo newTodo) {
		TodoTSVWriter todoTSVWriter = new TodoTSVWriter();
		boolean result = todoTSVWriter.save(RESOURCES, filePath, newTodo);
		return result;
	}
}
