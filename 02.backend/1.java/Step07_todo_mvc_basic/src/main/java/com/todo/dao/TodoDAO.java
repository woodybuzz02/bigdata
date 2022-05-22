package com.todo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.Todo;
import com.todo.utils.DBUtils;

// 'D'ata 'A'ccess 'O'bject, DB 접근을 담당하는 클래스
public class TodoDAO {

	private Todo todo;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	// 전체 Todo 조회 (try-catch, Java 7 이전 방식)
	public List<Todo> findAll() {
		// SELECT Query
		final String selectQuery = "SELECT * FROM todo";
		List<Todo> todos = new ArrayList<>();

		try {
			// Java와 MySQL의 연결 통로(Connection) 생성, DB 커넥션 연결
			connection = DBUtils.getConnection();
			// 통로를 통해 SQL을 전달할 객체 Statement 생성, DB로의 Query 전달 객체
			statement = connection.createStatement();
			// 실제 Query 전달 및 수행(진행시켜)
			resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Date dueDate = resultSet.getDate("due_date");
				boolean isCompleted = resultSet.getBoolean("is_completed");

				todo = new Todo(id, title, description, dueDate.toLocalDate(), isCompleted);
				todos.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제, 마지막으로 생성된 순서부터 거꾸로 해제
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return todos;
	}

	// 하나의 Todo 조회(try with resources, Java 7 이후 방식)
	public Todo findById(Long id) {
		// SELECT Query
		final String selectQuery = "SELECT * FROM todo WHERE id = ?";
		
		// Java & MySQL 연결을 위한 Connection 생성
		try (Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = createPreparedStatement(connection, selectQuery, id);
			ResultSet resultSet = preparedStatement.executeQuery();){
			// try()에서 () 내부에 작성할 수 있는 객체 혹은 인터페이스는 Autocloseable 인터페이스를 상속받은 것만 된다.
			
			// 결과값(ResultSet) 맵핑
			while (resultSet.next()) {
//				todo = new Todo(resultSet.getLong("id"), 
//								resultSet.getString("title"), 
//								resultSet.getString("description"), 
//								resultSet.getDate("due_date").toLocalDate(), 
//								resultSet.getBoolean("is_completed"));
				todo = new Todo.Builder(resultSet.getLong("id"))
						.title(resultSet.getString("title"))
						.description(resultSet.getString("description"))
						.dueDate(resultSet.getDate("due_date").toLocalDate())
						.isCompleted(resultSet.getBoolean("is_completed"))
						.build(); // 생성자 오버로딩에서 자유로워짐
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return todo;
	}
	
	private PreparedStatement createPreparedStatement(Connection connection, String sql, Long id) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, id);
		return preparedStatement;
	}

	public int save(Todo newTodo) {
		String insertQuery = "INSERT INTO todo (title, description,due_date) VALUES(?,?,?)";
		int affectedRows = 0; // 이해되었으면 굳이 할 필요없음.
		
		try (Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = createPreparedStatement(connection, insertQuery, newTodo);)
		{
			affectedRows = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows;
	}
	
	private PreparedStatement createPreparedStatement(Connection connection, String sql, Todo todo) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, todo.getTitle());
		preparedStatement.setString(2, todo.getDescription());
		preparedStatement.setString(3, todo.getDueDate().toString());
		return preparedStatement;
	}

	public Todo updateById(Long todoNumber, Todo todo2) {
		String updateQuery = "UPDATE todo title = ?,  description = ?, due_date = ? ";
		try (Connection connection = DBUtils.getConnection();
				){
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
}
