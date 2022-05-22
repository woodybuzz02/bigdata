package com.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import com.todo.cotroller.TodoController;
import com.todo.data.TodoTSVParser;
import com.todo.data.TodoTSVWriter;
import com.todo.model.Todo;

public class App {

	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		
		// 1. 데이터의 입출력 : 데이터를 읽어들임(read, 입력)
		final Path filePath = Paths.get(RESOURCES + "todo-data-simple.txt");
		Long numberOfRows = Files.lines(filePath).count();
		List<String> lines = Files.readAllLines(filePath);

		// 2. 입출력 데이터 파싱 : 데이터를 파싱하는 부분을 별도의 클래스 TodoTSVParser.java로 분리
		TodoTSVParser todoTSVParser = new TodoTSVParser();
		List<Todo> todos = todoTSVParser.parseLinesFromTSV(lines, numberOfRows.intValue());
		
		// cotroller 생성 
		TodoController todoController = new TodoController(todos);
		
		// 전체 Todos 조회
		todoController.findAll();
		
		// 하나의 Todo 결과 조회
		Long todoNumber = 2L;
		todoController.findById(todoNumber);
		
		// 할 일을 추가하는 부분을 별도의 클래스 TodoTSVWriter.java로 분리
//		TodoTSVWriter todoTSVWriter = new TodoTSVWriter();
		Todo newTodo = new Todo("산책하기", "강아지와 산책한다", LocalDate.of(2022, 04, 05)); 
//		todoTSVWriter.save(RESOURCES, filePath, newTodo);
		
		todoController.save(RESOURCES, filePath, newTodo);
	}
	
}
