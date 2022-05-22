package com.todo;

import java.time.LocalDate;

import com.todo.cotroller.TodoController;
import com.todo.model.Todo;

public class App {

	public static void main(String[] args) {
		
		
		// cotroller 생성 
		TodoController todoController = new TodoController();
		
//		// 전체 Todos 조회
//		todoController.findAll();
//		
//		// 하나의 Todo 결과 조회
//		Long todoNumber = 3L;
//		todoController.findById(todoNumber);
//		
//		// 하나의 Todo 등록
//		Todo newTodo = new Todo("산책하기", "강아지와 산책한다", LocalDate.of(2022, 04, 05)); 
//		todoController.save(newTodo);
//		
//		todoController.findAll();
		
		// 하나의 Todo 업데이트
		Long todoNumber = 3L;
		todoController.updateById(todoNumber, new Todo("낮잠자기", "낮잠을 잔다", LocalDate.of(2022, 05, 10)));
		
		
		// 하나의 Todo 삭제
		todoController.deleteById(todoNumber);
		
		todoController.findAll();

	}
	
}
