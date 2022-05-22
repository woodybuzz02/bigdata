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
	private Exception errorObject;
	
	public TodoController() {
		this.todoView = new TodoView();
		this.todoService = new TodoService();
	}

	// 전체 데이터 조회 처리를 위한 분기
	public void findAll() {
		// 현재 todos는 null
		// todos에 실제 데이터를 초기화 한 후에 todoView.findAll()을 호출해야 한다.
		todos = todoService.findAll();
		todoView.findAll(todos);
	}
	
	// 하나의 데이터 조회 처리를 위한 분기
	public void findById(Long id) {
		Todo todo = todoService.findById(id);
		
		if(todo != null) {
			todoView.findById(todo); 
		} else {
			// 해당하는 Todo 데이터가 존재하지않습니다., 예외 객체 생성
			errorObject = new Exception("해당하는 Todo 데이터가 존재하지않습니다.");
			// 예외 메시지
			todoView.errorPage(errorObject);
		}
		
	}
	
	public void save(Todo newTodo) {
		int result = todoService.save(newTodo);
		
		if(result > 0) {
			todoView.successPage();
		} else {
			todoView.errorPage();
		}
		
	}

	public void updateById(Long todoNumber, Todo newTodo) {
		Todo previousTodo = todoService.updateById(todoNumber, newTodo);
		
		if(previousTodo != null) {
			todoView.update(previousTodo);
		} else {
			errorObject = new Exception("수정 실패");
			todoView.errorPage(errorObject);
		}
	}

	public void deleteById(Long todoNumber) {
		Todo deletedTodo = todoService.deleteById(todoNumber);
		
		if(deletedTodo != null) {
			todoView.delete(deletedTodo);
		} else {
			errorObject = new Exception("삭제 실패");
			todoView.errorPage(errorObject);
		}
	}
}

