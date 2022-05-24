package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id // PK·Î ¸ÊÇÎ ¼³Á¤
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name="MAJOR_ID")
	private Major major;
	
	
	public Student() {}
	
	public Student(Long id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
	}
	public Student(String studentName) {
		this.studentName = studentName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	
	
}
