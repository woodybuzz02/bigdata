package com.sample;

// 클래스 외부에는 package 선언과 import 문장 외에 아무것도 선언하지 않는다.

// Person 클래스 정의
public class Student {
	// 멤버 변수 (멤버 필드) : Student(학생)이 가진 속성들 "선언, 정의"
	int studentID; // 학번
	String studentName; // 학생 이름
	int grade; // 학년
	String address; // 주소, 사는 곳
	
	// 기본 생성자(함수), Default Constructor
//	public Student() {
//		System.out.println("Student() 호출");
//	}
	public Student() {}
	// 학생 이름고 학년을 매개변수로 받는 생성자 작성 , 이렇게 작성하면 기본생성자를 생성하지 않음. 굳이 하고 싶다면 직접 써야됨.
	public Student(String studentName, int grade) {
		// 갈색 : 지역 변수(Local variable)
		// 파란색 : 멤버 변수
		this.studentName = studentName;
		this.grade = grade;
		
	}
	

	// 멤버 메서드 : Student(학생)이 할 수 있는 기능, 행위

	// 1. 첫 번째 멤버 메서드, 학생의 이름과 주소만 출력해주는 메서드
	// prototype: (접근제어자) 반환타입 메서드명() {}
	// void : 반환 타입이 따로 없을 때 사용하는 키워드

	// 현재 showStudent()는 학생의 이름과 주소를 출렵나 해주고 있고,
	// 별도의 값(value)을 반환하고 있지는 않음.
	// 왜냐하면 return이라는 키워드가 없기 때문에
	public void showStudent() {
		System.out.println(studentName + "," + grade);
	}
	//ctrl+shift+f는 줄정리
}
