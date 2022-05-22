
package com.todo.model;

import java.time.LocalDate;

public class Todo {
	
	// 멤버(Member) : 해당 클래스가 가지고 있는 구성원(속성, 메서드)
	// 멤버 필드(멤버 변수)
	private Long id; // 할 일 번호
	private String title; // 할 일 제목
	private String description; // 할 일 내용
	private LocalDate dueDate; // 할 일 마감기간
	private Boolean isCompleted; // 진행 여부

	// 생성자
	public Todo(Long id, String title, LocalDate dueDate, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = false; // 기본값은 false
	}

	public Todo(String title, String description, LocalDate dueDate) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}

	// getter, setter 정의
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", isCompleted=" + isCompleted + "]";
	}

	
	
}
