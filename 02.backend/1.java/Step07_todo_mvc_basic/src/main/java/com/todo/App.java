package com.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import com.todo.cotroller.TodoController;
import com.todo.model.Mouse;
import com.todo.model.Todo;
import com.todo.utils.DBUtils;

public class App {
	
	

	// main 메서드
	public static void main(String[] args) {
		
		Mouse m = new Mouse();
		m.setName("경로");
		
		
		// 초기 테이블 생성
//		DBUtils.dropAndCreateTable();
		
		TodoController todoController = new TodoController();
		
		// 전체 Todo 조회(SELECT * FROM todo;)
        todoController.findAll();
        
        // 할 일 순서 번호(id)로 하나의 Todo 조회
        long todoNumber = 2L;
        todoController.findById(todoNumber);
        
        // 하나의 Todo 등록
        Todo todo = new Todo.Builder(null)
        		.title("빵먹기")
        		.description("커피랑 같이 먹는다.")
        		.dueDate(LocalDate.of(2022, 05, 22))
        		.build();
        
        
        todoController.save(todo);
        todoController.updateById(todoNumber, new Todo("편의점가기", "포켓몬빵을 산다", LocalDate.of(2022, 05, 13)));
	}

	
}

