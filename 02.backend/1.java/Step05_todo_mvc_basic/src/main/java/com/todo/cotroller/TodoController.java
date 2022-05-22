package com.todo.cotroller;

import java.nio.file.Path;
import java.util.List;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import com.todo.view.TodoView;

public class TodoController {
	// 사용자의 요청에 따라 액션을 분기'만' 해주는 역할
	
	// todos 리스트를 필드로 선언
	private List<Todo> todos;
	private final TodoView todoView; // 구성관계(Composition)
	private final TodoService todoService;
	
	public TodoController(List<Todo> todos) {
		this.todos = todos;
		this.todoView = new TodoView();
		this.todoService = new TodoService();
	}

	// 전체 데이터 조회 처리를 위한 분기
	public void findAll() {
		// todoView야, 사장님(App.java)이 전체 결과값 조회 해달래~
		todoView.findAll(todos);
	}
	
	// 하나의 데이터 조회 처리를 위한 분기
	public void findById(Long id) {
		// TodoService에게서 id값으로 찾은 todo 데이터 전달 받음
		Todo todo = todoService.findById(todos, id);
		// todoView야, 사장님(App.java)이 하나의 결과값 조회 해달래~
		todoView.findById(todo); 
	}
	
	public void save(String RESOURCES, Path filePath, Todo newTodo) {
		boolean result = todoService.save(RESOURCES, filePath, newTodo);
		
		if(result) {
			todoView.successPage();
		} else {
			todoView.errorPage();
		}
	}
}

