package dev.sample;

import dev.sample.model.Major;
import dev.sample.model.Student;

public class App {
	public static void main(String[] args) {
		
		Student student1 = new Student(1L, "Seo");
		Student student2 = new Student(1L, "Kang");
		
		Major major = new Major(1L, "컴퓨터 공학");
		
		student1.setMajor(major);
		student2.setMajor(major);
		
		// student1이 속한 학과 조회
		Major foundMajor = student1.getMajor();
		System.out.println(foundMajor);
	}
}