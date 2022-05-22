package com.todo.view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.todo.model.Todo;

public class TodoView {
	// 실제 결과값 출력을 담당하는 역할
	
	//1. 전체 조회 결과 출력
	public void findAll(List<Todo> todos) {
		System.out.println("전체 조회 결과 입니다.");
		for (Todo todo : todos) {
			System.out.println(String.format("%d 번째로 해야 할 일은 %s 입니다.", todo.getId(), todo.getTitle()));
		    System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("기한은 yyyy년 MM월 dd일 까지입니다.")));
		    System.out.println();
		}
	}

	public void findById(Todo todo) {
		System.out.println("하나의 데이터 조회 결과 입니다.");
		System.out.println(String.format("%d 번째로 해야 할 일은 %s 입니다.", todo.getId(), todo.getTitle()));
	    System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("기한은 yyyy년 MM월 dd일 까지입니다.")));
	    System.out.println();
	}

	public void successPage() {
		System.out.println("정상 등록 되었습니다.");
	}

	
	public void errorPage() {
		System.out.println("문제가 발생하였습니다.");
		
	}
	
	public void errorPage(Exception error) {
		System.out.println("문제가 발생하였습니다."+ error.getMessage());
		
	}

	public void update(Todo previousTodo) {
		System.out.println("정상 수정되었습니다.");
		System.out.println("수정 전 : "+previousTodo);
		
	}

	public void delete(Todo deletedTodo) {
		System.out.println("정상 삭제정되었습니다.");
		System.out.println("삭제된 정보 : "+deletedTodo);
		
	}

	
	
	
}
