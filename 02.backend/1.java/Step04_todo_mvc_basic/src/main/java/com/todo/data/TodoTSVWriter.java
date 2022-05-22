package com.todo.data;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import com.todo.model.Todo;

public class TodoTSVWriter {
	FileOutputStream fileOutputStream;
	OutputStreamWriter outputStreamWriter;
	BufferedWriter bufferedWriter;

	// 새로운 Todo를 등록
	public boolean save(String RESOURCES, Path filePath, Todo newTodo) {
		boolean result = false;
		try {
			// 데이터를 파일에 쓰기 위한 준비
			fileOutputStream = new FileOutputStream(RESOURCES + "todo-data-simple.txt", true);
	        outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
	        bufferedWriter = new BufferedWriter(outputStreamWriter);
	        
	        Long numberOfRows = Files.lines(filePath).count();
	        int numberOfTodos = numberOfRows.intValue();
	        
	        numberOfTodos++;
	        bufferedWriter.newLine();
	        bufferedWriter.write(numberOfTodos + "\t");
	        bufferedWriter.write("밥먹기" + "\t");
	        bufferedWriter.write("2022-03-08" + "\t");
	        bufferedWriter.write("밥을 맛있게 먹는다" + "\t");
	        
	        if(numberOfRows < Files.lines(filePath).count()) {
	        	return true;
	        } else {
	        	return false;
	        }
	        
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			 // 자원 해제
	        try {
	        	bufferedWriter.close();
				outputStreamWriter.close();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	
		return result;
	}

}
