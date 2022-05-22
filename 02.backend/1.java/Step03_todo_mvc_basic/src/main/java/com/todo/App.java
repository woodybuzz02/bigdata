package com.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.todo.data.TodoTSVParser;
import com.todo.model.Todo;

public class App {

	// 객체 멤버 변수 RESOURCES 초기화
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		
		/**
		 * 1. 데이터의 입출력
		 * 2. 입출력데이터 파싱(Parsing)
		   3. 결과값 출력(findAll, findById) 
		 */
		
		// 데이터 읽어들임(read, 입력)
		final Path filePath = Paths.get(RESOURCES + "todo-data-simple.txt");
		Long numberOfRows = Files.lines(filePath).count();
		List<String> lines = Files.readAllLines(filePath);
		
		// 데이터를 파싱하는 부분을 별도의 클래스 TodoTSVParsr.java로 분리
		TodoTSVParser todoTSVParser = new TodoTSVParser();
		Todo[] todos = todoTSVParser.parseLinesFromTSV(lines, numberOfRows.intValue());
		
		// 파싱된 데이터를 활용하여 결과 데이터 출력하는 부분
		// 전체 Todos 조회
		findAll(todos);
		Long todoNumber = 2L;
		System.out.println(todoNumber+"번 쩨로 할 일은"+findById(todos, todoNumber).getTitle()+"입니다.");
	}
	
	// 전체 Todos 조회
	static void findAll(Todo[] todos) { //static이 없으면 App 클래스의 인스턴스 메서드가 되기때문에, 인스턴스 멤버는 객체를 생성한 후에 접근이 가능하기 때문에
		System.out.println( Arrays.toString(todos) );
		}
	
	// 할 일 순서 번호로 하나의 Todo 조회
	public static Todo findById(Todo[] todos, Long todoNumber) {
		for (Todo todo : todos) {
			if(todo.getId() == todoNumber) {
				return new Todo(todo.getId(), todo.getTitle(), todo.getDueDate(), todo.getDescription());
			}
		}
		return null;
	}
	

}