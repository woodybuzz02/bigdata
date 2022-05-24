package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Major {
	@Id // PK�� ���� ����
	@Column(name = "MAJOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "MAJOR_NAME")
	private String majorName;
	
	
	
	public Major() {}
	
	
	
	public Major(String majorName) {
		super();
		this.majorName = majorName;
	}



	public Major(Long id, String majorName) {
		super();
		this.id = id;
		this.majorName = majorName;
		
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	@Override
	public String toString() {
		return "Major [id=" + id + ", majorName=" + majorName + "]";
	}
	
	
	
}
