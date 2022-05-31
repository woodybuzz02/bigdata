package dev.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.example.demo.model.Todo;
import dev.example.demo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoRepository repository;

	//@Override 에러 나신분들 JRE1.6으로 변경하면 해결되긴 합니다 참고하세요!
	public List<Todo> findAll() {
		//DB접근해서 데이터 조회 -> service가 하지않고, DAO, Repository가 한다.
		return repository.findAll();
		
		//JDBC에서는 ORM처리 필요.
		
		/*
		 * Mouse m = new Mouse();
		 * m.setName(rs.getString("name")); // Object(Mouse) - Relation(Mouse table) Mapping
		 */
		
		
	}

	public Todo save(Todo todo) {
		
		return repository.save(todo);
	}
	
	public List<Todo> update(Todo todo){
		final Optional<Todo> foundTodo = repository.findById(todo.getId());
		//NullPointer 예외를 방지하기 위함
		
		foundTodo.ifPresent(newTodo -> {//id값에 의한 엔티티가 존재하면(ifPresent)
			newTodo.setDate(todo.getDate());
			newTodo.setDescription(todo.getDescription());
			newTodo.setTitle(todo.getTitle());
			// 지역변수 todo : update할 새로운 데이터
			// newTodo : update완료 후 DB에 persist할 데이터
			
			repository.save(newTodo);
		});
		
		return repository.findAll();
	}

	

	
	
	
	
}
