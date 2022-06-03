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
	
	/**
	 * 메서드에 대한 설명을 잠깐 설명할 때 쓰는 것
	 * 예시) 전체 할 일 목록을 조회한다.
	 * @return 전체 할 일 목록(list)
	 */

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
	/**
	 * 할 일을 등록한다.
	 * 
	 * @param todo 새롭게 등록할 할 일 정보
	 * @return 등록된 할 일 정보
	 */
	public Todo save(Todo todo) {
		
		return repository.save(todo);
	}
	
	/**
	 * 해당 할 일을 수정한다.
	 * 
	 * @param todo 수정할 할 일 정보
	 * @return 수정된 할 일 정보
	 */
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
	
	/**
	 * 해당 할 일을 삭제한다.
	 * 
	 * @param id 삭제할 할 일의 id
	 * @return 삭제된 할 일 정보
	 */
	@Override
	public List<Todo> delete(Long id) {
		final Optional<Todo> foundTodo = repository.findById(id);
		foundTodo.ifPresent(todo ->{
			repository.delete(todo);
		});
		
		return repository.findAll();
	}

	

	
	
	
	
}
