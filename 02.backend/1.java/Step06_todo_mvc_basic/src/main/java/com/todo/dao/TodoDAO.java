package com.todo.dao;

import java.util.List;

import com.todo.database.TodoDatabase;
import com.todo.model.Todo;

//Data access object, DB 접근을 담당하는 클래스
public class TodoDAO {
	
	// 멤버 필드
	private final TodoDatabase todoDatabase;

	public TodoDAO() {
		this.todoDatabase = new TodoDatabase();
	}
	
	public List<Todo> findAll() {
		List<Todo> todos = TodoDatabase.getTodos();
		return todos;
//		return TodoDatabase.getTodoDatabase();
	}

	public Todo findById(Long id) {
		// DB에서 id값과 일치하는 Todo 데이터 조회
		return todoDatabase.findById(id);
		
		
	}

	public Boolean save(Todo newTodo) {
		return todoDatabase.save(newTodo);
		
	}

	public Todo updateById(Long todoNumber, Todo newTodo) {
		return todoDatabase.updateById(todoNumber, newTodo);
	}

	public Todo deleteById(Long todoNumber) {
		return todoDatabase.deleteById(todoNumber);
	}
	
	//The blank final field todoDatabase may not have been initialized <- 초기화하기

	
}
