
package com.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.todo.model.Todo;

public class App {
	
	// 객체 멤버 변수 RESOURCES 초기화
	private static final String RESOURCES = "src/main/resources/";
	// 객체 멤버 변수 DATE_PATTERN 초기화
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void main(String[] args) throws IOException {
		
		final Path filePath = Paths.get(RESOURCES + "todo-data-simple.txt");
		Long numberOfRows = Files.lines(filePath).count(); // 값이 더 큰 타입에서 작은 타입으로 변환할 때는 명시적으로 변환하려는 타입을 써야함.
//		System.out.println(numberOfRows.intValue());
		// Todo 클래스의 인스턴스를 담을 Todo 타입의 객체 배열
		Todo[] todos = new Todo[numberOfRows.intValue()];
		
		// java.util.List
		List<String> lines = Files.readAllLines(filePath);
//		System.out.println(lines);
		
		int index = 0;
		for (String line : lines) {
			final String[] columns = line.split("\t");
			
			final Long id = Long.parseLong(columns[0]);
			final String title = columns[1];
			final LocalDate dueDate = LocalDate.parse(columns[2], DATE_PATTERN);
			final String description = columns[3];
			
			// id, title, dueDate, description을 어디에 쓰지?
			Todo todo = new Todo(id, title, dueDate, description);
//			System.out.println(todo);
			
			todos[index] = todo;
			index++;
			
//			todos[index++] = new Todo(Long.parseLong(columns[0]),
//									columns[1],
//									LocalDate.parse(columns[2], DATE_PATTERN),
//									columns[3]
//									);
		}//forEach() 끝
		
		// 전체 Todos 조회
//		System.out.println( Arrays.toString(todos) );
		
//		for (int i = 0; i < todos.length; i++) {
//			System.out.println(todos[i]); // 참조변수 값 그대로 출력하면 내부적으로 toString()이 호출됨
//		}
		
		// 할 일 순서 번호(임의)로 하나의 Todo 조회
		Long todoNumber = 2L;
		for (Todo todo : todos) {
			if(todo.getId() == todoNumber) System.out.println(todo);
		}
		
	}

}